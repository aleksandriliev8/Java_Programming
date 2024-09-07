package problem1;

import java.util.Scanner;

import static java.util.FormatProcessor.FMT;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//        System.out.printf("Enter Fahrenheit: ");
//        double fahrenheit = input.nextDouble();
//        double celsius =  5.0 / 9.0 * (fahrenheit - 32);

        // 1st variant
        /*        System.out.printf("Celsius: %.2f%n", celsius);*/

        // %n - new line

        // 1st variant
/*        String message = String.format("Celsius: %.2f", celsius);
        System.out.println(message);*/

        //3rd variant
        /*String message = FMT."Celsius: %.2f\{celsius}";
        System.out.println(message);*/

        //b)

//        System.out.printf("Enter celsius: ");
//        double celsius = input.nextDouble();
//        double fahrenheit = 9.0 / 5.0 * celsius + 32;
//
//        String message = FMT."Fahrenheit: %.2f\{fahrenheit}";
//        System.out.println(message);

        //c)

        String menu = """
                1. Fahrenheit to Celsius
                2. Calsius to Fahrenheit
                Choose an option:
                """;

        //sout + Tab
        System.out.println(menu);
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.printf("Enter Fahrenheit: ");
            double fahrenheit = input.nextDouble();
            double celsius = 5.0 / 9.0 * (fahrenheit - 32);
            String message = FMT."Celsius: %.2f\{celsius}";
            System.out.println(message);
        } else if (choice == 2) {
            System.out.printf("Enter celsius: ");
            double celsius = input.nextDouble();
            double fahrenheit = 9.0 / 5.0 * celsius + 32;

            String message = FMT."Fahrenheit: %.2f\{fahrenheit}";
            System.out.println(message);
        } else {
            System.out.printf("Incorrect option: ");
        }
    }
}