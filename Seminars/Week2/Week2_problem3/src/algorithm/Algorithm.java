package algorithm;

import java.util.Scanner;

public class Algorithm {

    public static int factorial(int x){
        int result = 1;

        if(x == 0){
            return result;
        }

        for (int i = x; i > 0 ; i--) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the power of Euler's Number: ");
        int x = input.nextInt();
        double result = 0;

        if (x == 0){
            System.out.println(1);
        }else{
            int i = 0;

            while(true){

                if(i > 0 && Math.abs(Math.pow(x, i) / (double)factorial(i)) - Math.abs(Math.pow(x - 1, i) / (double)factorial(i)) < 0.001){
                    break;
                }
                result += Math.pow(x, i) / (double)factorial(i);
                i++;
            }
            System.out.println(result);
        }
    }
}
