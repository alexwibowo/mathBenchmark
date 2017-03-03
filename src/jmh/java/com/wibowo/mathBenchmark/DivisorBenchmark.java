package com.wibowo.mathBenchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.atomic.AtomicInteger;

public class DivisorBenchmark {

    public static final double[] ALL_DIVIDEND = new double[]{
            1.0,
            2.95,
            3.11,
            10.01,
            Math.PI
    };

    public static final int[] ALL_DIVISOR = new int[]{
            10,
            100,
            1000,
            10000
    };

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        private final Divisor divisor = new Divisor();


    }

    @State(Scope.Thread)
    public static class ThreadState {

        private AtomicInteger invocationCounter;


        private double dividend;

        private int divisor;

        @Setup(Level.Iteration)
        public void setupIteration() {
            invocationCounter = new AtomicInteger(0);
        }


        @Setup(Level.Invocation)
        public void setupInvocation() {
            final int invocationNumber = invocationCounter.getAndIncrement();

            int dividendIndex = invocationNumber % ALL_DIVIDEND.length;
            dividend = ALL_DIVIDEND[dividendIndex];

            int divisorIndex = invocationNumber % ALL_DIVISOR.length;
            divisor = ALL_DIVISOR[divisorIndex];
        }

    }

    @Benchmark
    public double normalDivisionBenchmark(final BenchmarkState benchmarkState,
                                          final ThreadState threadState) {
        return benchmarkState.divisor.normalDivision(threadState.dividend, threadState.divisor);
    }

    @Benchmark
    public double multiplicationDivisionBenchmark(final BenchmarkState benchmarkState,
                                                  final ThreadState threadState) {
        return benchmarkState.divisor.divisionUsingMultiplication(threadState.dividend, threadState.divisor);
    }
}
