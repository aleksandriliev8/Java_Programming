package problem4;

import java.util.Scanner;

public class fourNucleotideRepresentationOfNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter four digit number");
        int number = input.nextInt();

        if (number >= 1000 && number <= 9999){

            String strResult = "";

            while(number > 0)
            {
                int digit = number % 10;

                switch (digit % 4)
                {
                    case 0 :
                        strResult = "A" + strResult;
                        break;
                    case 1 :
                        strResult = "C" + strResult;
                        break;
                    case 2 :
                        strResult = "G" + strResult;
                        break;
                    case 3 :
                        strResult = "T" + strResult;
                        break;
                }

                number /= 10;
            }
            System.out.println(strResult);
        } else {
            System.out.println("The input is not a four digit number");
        }
    }
}
