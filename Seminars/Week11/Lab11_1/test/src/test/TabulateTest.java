package test;

import com.functions.Functions;
import com.functions.Tabulate;
import services.Computable;

public class TabulateTest {
    public static void main(String[] args) {
        Tabulate.tabulateFunction(1, 25, 25, new Computable() {
            @Override
            public double function(double x) {
                return 1.0 / x;
            }
        });

        Functions functions = new Functions();
        Tabulate tabulate = new Tabulate(functions.getSinFunction());
        tabulate.tabulate(1, 25, 25);
    }
}
