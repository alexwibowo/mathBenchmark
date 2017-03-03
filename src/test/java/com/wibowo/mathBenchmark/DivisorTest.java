package com.wibowo.mathBenchmark;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class DivisorTest {

    private static final double EPSILON = Math.pow(10, -16);

    @DataPoints("divisor")
    public static int[] divisors = new int[]{
            10, 100, 1000, 10000
    };

    @DataPoints("dividend")
    public static double[] dividend = new double[]{
            Math.PI, 10.00, 3.11, 2.95
    };


    @Theory
    public void test_division_using_two_mechanism(
            final @FromDataPoints("dividend") double dividend,
            final @FromDataPoints("divisor") int divisor) {
        final double normalVersion = new Divisor().normalDivision(dividend, divisor);
        final double multiplicationVersion = new Divisor().divisionUsingMultiplication(dividend, divisor);
        assertEquals(
                "Expect normal division [" + normalVersion + "] to be equal to multiplication [" + multiplicationVersion + "]",
                normalVersion, multiplicationVersion, EPSILON
        );
    }

}