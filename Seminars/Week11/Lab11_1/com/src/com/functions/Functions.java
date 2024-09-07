package com.functions;

import services.Computable;

public class Functions {
    private class SinFunction implements Computable {
        @Override
        public double function(double x) {
            return Math.sin(x);
        }
    }

    private class ExpFunction implements Computable {

        @Override
        public double function(double x) {
            return 0;
        }
    }

    public Computable getSinFunction(){
        return new SinFunction();
    }

    public Computable getExpFunction(){
        return new ExpFunction();
    }
}
