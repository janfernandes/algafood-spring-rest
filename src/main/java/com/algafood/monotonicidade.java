//package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//class Main {
//
//    public static void main(String args[]) throws Exception {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                        BufferedReader br = new BufferedReader(new FileReader("C:/mono.txt"));
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            int caseActual = Integer.parseInt(br.readLine());
//            long[] a = new long[caseActual];
//            String line = br.readLine();
//            String[] strs = line.trim().split("\\s+");
//            for (int j = 0; j < caseActual; j++) {
//                a[j] = Long.parseLong(strs[j]);
//            }
//            isMono(Arrays.stream(a).toArray());
//        }
//    }
//
//    private static void isMono(long[] monoArray) {
//        Set<Long> aux = Arrays.stream(monoArray).boxed().collect(Collectors.toSet());
//        //se forem todos diferentes ja retorna q nao
//        if (aux.size() == monoArray.length) {
//            printNotMono();
//            return;
//        }
//        //se forem todos iguais ja retorna q sim
//        if (aux.size() == 1) {
//            printMono();
//            return;
//        }
//        //gerar todas as subsequencias
//        generateSubSequences(monoArray);
//    }
//
//    private static void generateSubSequences(long[] monoArray) {
//        int inf = 0;
//        int sup = monoArray.length;
//        for (int i = inf; i < sup; i++) {
//            for (int j = i + 1; j < sup; j++) {
//                List<Long> collect = IntStream.range(i, j + 1).mapToObj(v -> monoArray[v]).collect(Collectors.toList());
//                if (collect.stream().distinct().count() <= collect.size() / 2) {
//                    printMono();
//                    return;
//                }
//            }
//            inf++;
//        }
//        printNotMono();
//    }
//
//    private static void printMono() {
//        System.out.println("monótona");
//    }
//
//    private static void printNotMono() {
//        System.out.println("não monótona");
//    }
//}
//
