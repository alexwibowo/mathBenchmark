package com.wibowo.mathBenchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.atomic.AtomicInteger;

public class DivisorBenchmark {

    public static final double[] ALL_DIVIDEND = new double[]{
            Math.PI,
            Math.PI + 1.5
    };

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        private final Divisor divisor = new Divisor();
    }

    @State(Scope.Thread)
    public static class ThreadState {

        private AtomicInteger iterationCounter;

        private double dividend;

        @Setup(Level.Trial)
        public void setupTrial() {
            iterationCounter = new AtomicInteger(0);
        }

        @Setup(Level.Iteration)
        public void setupIteration() {
            final int iterationNumber = iterationCounter.getAndIncrement();

            int dividendIndex = iterationNumber % ALL_DIVIDEND.length;
            dividend = ALL_DIVIDEND[dividendIndex];
        }
    }

    @Benchmark
    public double normalDivisionBenchmark(final BenchmarkState benchmarkState,
                                          final ThreadState threadState) {
        return benchmarkState.divisor.normalDivision(threadState.dividend);
    }

    @Benchmark
    public double multiplicationDivisionBenchmark(final BenchmarkState benchmarkState,
                                                  final ThreadState threadState) {
        return benchmarkState.divisor.divisionUsingMultiplication(threadState.dividend);
    }
}
