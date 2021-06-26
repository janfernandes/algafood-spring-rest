////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//class Main {
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/cristais.txt"));
//        int casesLen = Integer.parseInt(br.readLine().split(" ")[0]);
//        if (casesLen == 0) {
//            System.out.println(0);
//        } else {
//            int cristaisSize;
//            ArrayList<Set<Integer>> cristaisList = new ArrayList<>();
//            cristaisList.add(new HashSet<>());
//
//            int value;
//            for (int i = 0; i < casesLen; i++) {
//                cristaisSize = Integer.parseInt(br.readLine().split(" ")[0]);
//                if(cristaisSize==0)
//                    System.out.println(0);
//                else {
//                    long[] entrada = new long[cristaisSize];
//                    for (int c = 0; c < cristaisSize; c++) {
//                        value = Integer.parseInt(br.readLine().split(" ")[0]);
//                        entrada[c] = value;
//                    }
//                    doACase(entrada);
//                }
//            }
//        }
//    }
//
//    private static void doACase(long[] entrada) {
//        int inf = 0;
//        int sup = entrada.length;
//        int maxValue = 0;
//        int actualTam;
//        for (int i = inf; i < sup; i++) {
//            for (int j = i + 1; j < sup; j++) {
//                List<Long> collect = IntStream.range(i, j + 1).mapToObj(v -> entrada[v]).collect(Collectors.toList());
//                actualTam = collect.size();
//                if (collect.stream().distinct().count() == actualTam) {
//                    if (actualTam > maxValue)
//                        maxValue = actualTam;
//                }
//            }
//            inf++;
//        }
//        if (maxValue == 0)
//            maxValue = 1;
//        System.out.println(maxValue);
//    }
//
//}
