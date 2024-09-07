package RouteCipher;

import java.util.Scanner;

public class RouteCipher {

    private int key;

    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void peelTopRight(char[][] matrix, int minRow, int minCol, int maxRow, int maxCol, char[] result, int index){

        //putting the letters from the last column from last to first
        for (int i = maxRow; i >= minRow ; i--) {
            result[index++] += matrix[i][maxCol];
        }

        //putting the letters from first remaining row from top right to top left(without the letter in the corner)
        for (int j = maxCol - 1; j >= minCol ; j--) {
            result[index++] += matrix[minRow][j];
        }

        //looking if there are more layers to be printed
        if(maxRow - minRow > 0 && index != result.length){
            //if yes we recursively call the function to read the data from bottom left of the submatrix
            peelBottomLeft(matrix, minRow + 1, minCol, maxRow, maxCol - 1, result, index);
        }
    }

    public void peelBottomLeft(char[][] matrix, int minRow, int minCol, int maxRow, int maxCol, char[] result, int index) {

        //putting the letters from the first column from first to last
        for (int i = minRow; i <= maxRow; i++) {
            result[index++] += matrix[i][minCol];
        }

        //putting the letters from the last row from first to last
        for (int j = minCol + 1; j <= maxCol; j++) {
            result[index++] += matrix[maxRow][j];
        }

        //looking if there are more layers to be printed
        if(maxRow - minRow > 0 && index != result.length) {
            //if yes we recursively call the function to read the data from top right of the submatrix
            peelTopRight(matrix, minRow, minCol + 1, maxRow - 1, maxCol, result, index);
        }
    }

    int countLetters(char[] cipherTextChar){
        int count = 0;

        for (int i = 0; i < cipherTextChar.length; i++) {
            char current = cipherTextChar[i];

            if((current > 64 && current < 91) || (current > 96 && current < 123)){
                count++;
            }
        }
        return count;
    }

    char[] onlyLetters(char[] cipherTextChar){
        char[] newCipherChar= new char[countLetters(cipherTextChar)];
        int index = 0;

        for (int i = 0; i < cipherTextChar.length; i++) {
            char current = cipherTextChar[i];

            //adding only the letters and ignoring other symbols
            if((current > 64 && current < 91) || (current > 96 && current < 123)){
                newCipherChar[index++] = current;
            }
        }
        return newCipherChar;
    }

    public char[][] createBlockForEncryption(char[] cipherTextChars, int rows, int cols){
        char[][] matrix = new char[rows][cols];

        //creating the matrix
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //if we have already put all letters from the plaintext, we continue adding in the matrix only Xs
                if(index == cipherTextChars.length) {
                    matrix[i][j] = 'X';
                } else {
                    //if there is still unwritten data from the plaintext we put each letter in the matrix
                    matrix[i][j] = cipherTextChars[index];
                    index++;
                }
            }
        }
        return matrix;
    }

    public String encrypt(final String plainText) {
        //finding the needed parameters of the matrix
        int cols = Math.abs(key);
        char[] cipherTextChars = plainText.toCharArray();
        cipherTextChars = onlyLetters(cipherTextChars);

        int rows = cipherTextChars.length / cols;

        //adding one more row if the number of symbols is not divisible by the key without a leftover
        if(cipherTextChars.length % cols > 0) {
            rows += 1;
        }

        //creating the matrix
        char[][] matrix = createBlockForEncryption(cipherTextChars,rows,cols);
        char[] cryptoText = new char[rows * cols];

        //if negative key we start adding letters form bottom right spirally
        if(key < 0){
            peelTopRight(matrix,0,0,rows-1,cols-1,cryptoText, 0);
        } else {
            // in the other case when key is positive we start from top left, continuing again spirally
          peelBottomLeft(matrix,0,0,rows-1,cols-1,cryptoText, 0);
        }

        String resString = new String(cryptoText);
        return resString;
    }

    public void fillTopRightMatrix(char[][] matrix, int minRow, int minCol, int maxRow, int maxCol, char[] cryptoText, int index) {

        //putting the letters from the last column from last to first
        for (int i = maxRow; i >= minRow ; i--) {
            matrix[i][maxCol] = cryptoText[index++];
        }

        //putting the letters from first remaining row from top right to top left(without the letter in the corner)
        for (int j = maxCol - 1; j >= minCol ; j--) {
            matrix[minRow][j] = cryptoText[index++];
        }

        //looking if there are more layers to be printed
        if(maxRow - minRow > 0 && index != cryptoText.length){
            //if yes we recursively call the function to read the data from bottom left of the submatrix
            fillBottomLeftMatrix(matrix, minRow + 1, minCol, maxRow, maxCol - 1, cryptoText, index);
        }
    }

    public void fillBottomLeftMatrix(char[][] matrix, int minRow, int minCol, int maxRow, int maxCol, char[] cryptoText, int index) {
        //putting the letters from the first column from first to last
        for (int i = minRow; i <= maxRow; i++) {
            matrix[i][minCol] = cryptoText[index++];
        }

        //putting the letters from the last row from first to last
        for (int j = minCol + 1; j <= maxCol; j++) {
            matrix[maxRow][j] = cryptoText[index++];
        }

        //looking if there are more layers to be printed
        if(maxRow - minRow > 0 && index != cryptoText.length) {
            //if yes we recursively call the function to read the data from top right of the submatrix
            fillTopRightMatrix(matrix, minRow, minCol + 1, maxRow - 1, maxCol, cryptoText, index);
        }
    }

    public char[] readTheMatrix(char[][] matrix, int rows, int cols, int size){
        char[] decryptedText = new char[size];

        int index = 0;
        for (int i = 0; i < rows && index < size; i++) {
            for (int j = 0; j < cols && index < size; j++) {
                decryptedText[index++] = matrix[i][j];
            }
        }
        return decryptedText;
    }

    public String decrypt(final String cipherText) {

        int cols = Math.abs(key);
        char[] cryptoText  = cipherText.toCharArray();
        cryptoText = onlyLetters(cryptoText);

        int rows = cryptoText.length / cols;

        //adding one more row if the number of symbols is not divisible by the key without a leftover
        if(cryptoText.length % cols > 0) {
            rows += 1;
        }

        char[][] matrix = new char[rows][cols];
        if(key < 0){
            fillTopRightMatrix(matrix,0,0,rows-1,cols-1,cryptoText, 0);
        } else {
            fillBottomLeftMatrix(matrix, 0, 0, rows - 1, cols - 1, cryptoText, 0);
        }

        String resString = new String(readTheMatrix(matrix,rows,cols,cryptoText.length));
        return resString;
    }

    @Override
    public String toString() {
        return "";
    }
}
