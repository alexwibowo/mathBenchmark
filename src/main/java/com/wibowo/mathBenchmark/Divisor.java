package com.wibowo.mathBenchmark;

public final class Divisor {

    private static final double[] MULTIPLIER = new double[]{
            Math.pow(10, -1),
            Math.pow(10, -2),
            Math.pow(10, -3),
            Math.pow(10, -4),
    };

    public double normalDivision(final double dividend,
                                 final int divisor) {
        return dividend / divisor;
    }

    public double divisionUsingMultiplication(final double dividend,
                                              final int divisor) {
        final int e = (int) Math.log10(divisor) - 1;
        final double multiplier = MULTIPLIER[e];
        return dividend * multiplier;
    }


}
