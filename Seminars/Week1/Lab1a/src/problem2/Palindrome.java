package problem2;

import java.util.Scanner;

public class Palindrome {
    // main + Tab
    //psvm + Tab

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five digit number:" );
        int number = input.nextInt();

        if(number >= 10_000 && number <= 99_999) {

            int originalNumber = number;
            int lastD = number % 10;
            number /= 10;
            int fourthD = number % 10;
            number /= 10;
            int thirdD = number % 10;
            number /= 10;
            int secondD = number % 10;
            number /= 10;
            int firstD = number;

            String resultString;

            if(lastD == firstD && fourthD == secondD){
                resultString = String.format("%d is a palindrome", originalNumber);
            }
            else{
                resultString = String.format("%d is not a palindrome", originalNumber);
            }

            System.out.println(resultString);
        } else {
            System.out.println("The number is not five digits!");
        }
    }
}
