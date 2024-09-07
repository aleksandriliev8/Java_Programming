package problem3;

import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter four digit number: ");
        int number = input.nextInt();

        if(number >= 1000 && number <= 9999){
            int fourthD = (number % 10 + 7) % 10;
            number /= 10;
            int thirdD = (number % 10 + 7) % 10;
            number /= 10;
            int secondD = (number % 10 + 7) % 10;
            number /= 10;
            int firstD =(number + 7) % 10;

            number = firstD * 1000 + secondD * 100 + thirdD * 10 + fourthD;

            System.out.println(number);
        } else {
            System.out.println("Data is not a four digit number");
        }
    }
}
