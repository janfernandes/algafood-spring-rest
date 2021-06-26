////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
//class Main {
//    private static Map<Integer, Long> factorialMap = new HashMap<>();
//
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/DOS.txt"));
//        br.readLine();
//        int nChars = Integer.parseInt(br.readLine().split(" ")[0]);
//        for (int i = 0; i < nChars; i++) {
//            System.out.println(getFactorial(br.readLine().length()));
//        }
//    }
//
//    public static Long getFactorial(int number) {
//        Long val = factorialMap.get(number);
//        if (val != null) {
//            return val;
//        } else {
//            val = doFactorial(number);
//            factorialMap.put(number, val);
//            return val;
//        }
//    }
//
//    public static Long doFactorial(int number) {
//        if (number < 2) {
//            return 1L;
//        } else {
//            return number * doFactorial(number - 1);
//        }
//    }
//}
