package com.functions;

import services.Computable;

import java.util.Scanner;

public class Tabulate {
    private Computable callback;

    public Tabulate(Computable callback) {
        this.callback = callback;
    }

    public Computable getCallback() {
        return callback;
    }

    public void setCallback(Computable callback) {
        this.callback = callback;
    }

    public void tabulate(double a, double b, int steps) {
        tabulateFunction(a, b, steps, this.callback);
    }

    public static void tabulateFunction(double a, double b, int steps, Computable computable) {
        if(b < a){
            System.out.println("a is smaller than b");
            return;
        }

        if(steps <= 0 ) {
            System.out.println("steps has to be positive");
            return;
        }

        if(computable == null){
            System.out.println("computable cannot be null");
            return;
        }

        System.out.printf("%-20s%-20s%n", "X", "F(X)");
        double step = (b - a) / steps;
        int count = 0;
        Scanner input = new Scanner(System.in);

        for (double x = a; x <= b ; x+= step) {
            System.out.printf("%-20.2f%-20.2f%n", x, computable.function(x));
            count++;

            if(count % 20 == 0) {
                System.out.println("Pres Enter to continue...");
                input.nextLine();
            }
        }
    }
}
