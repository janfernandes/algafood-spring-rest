//package com.algafood;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.function.Function;
//
//class Sol {
//
//    private static final Function CACHED = memoize(Sol::uncached);
//
//    private static Object uncached(Object o) {
//        long n = (long) o;
//        if (n < 1) {
//            return n;
//        }
//        return n == 1
//                ? n
//                : n * factorial(n - 1);
//    }
//
//    public static Function memoize(Function f) {
//        Map lookup = new HashMap<>();
//        ReentrantLock lock = new ReentrantLock();
//        return input -> {
//            lock.lock();
//            try {
//                return lookup.computeIfAbsent(input, f);
//            } finally {
//                lock.unlock();
//            }
//        };
//    }
//
//    public static long factorial(long n) {
//        return (long) CACHED.apply(n);
//    }
//
//    public static void main(String args[]) throws Exception {
//        System.out.println(factorial(20));
//    }
//}
