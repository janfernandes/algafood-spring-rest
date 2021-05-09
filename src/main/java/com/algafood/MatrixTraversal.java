//package com.algafood;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.RunnerException;
//import org.openjdk.jmh.runner.options.Options;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//import org.openjdk.jmh.runner.options.TimeValue;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class MatrixTraversal {
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(MatrixTraversal.class.getSimpleName())
//                .warmupIterations(10)
//                .warmupTime(TimeValue.seconds(10))
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
//
//    @State(Scope.Thread)
//    public static class MatrixTraversalState {
//
//        private static int MATRIX_SIZE = 8*400;
//        private int[][] matrix = new int [MATRIX_SIZE][MATRIX_SIZE];
//
//        @Setup(Level.Trial)
//        public void setup() {
//            Random rand = new Random();
//            rand.setSeed(System.currentTimeMillis());
//            for (int row = 0; row < MATRIX_SIZE; row ++)
//                for (int col = 0; col < MATRIX_SIZE; col++)
//                    matrix[row][col] = rand.nextInt();
//        }
//
//        @TearDown(Level.Trial)
//        public void tearDown() {
//            matrix = new int [MATRIX_SIZE][MATRIX_SIZE];
//        }
//
//
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void columnBased(MatrixTraversalState state, Blackhole blackhole) {
//        long sum = 0L;
//        for (int row = 0; row < MatrixTraversalState.MATRIX_SIZE; row ++)
//            for (int col = 0; col < MatrixTraversalState.MATRIX_SIZE; col++)
//                sum += state.matrix[col][row];
//        blackhole.consume(sum);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void rowBased(MatrixTraversalState state, Blackhole blackhole) {
//        long sum = 0L;
//        for (int row = 0; row < MatrixTraversalState.MATRIX_SIZE; row ++)
//            for (int col = 0; col < MatrixTraversalState.MATRIX_SIZE; col++)
//                sum += state.matrix[row][col];
//        blackhole.consume(sum);
//    }
//}
