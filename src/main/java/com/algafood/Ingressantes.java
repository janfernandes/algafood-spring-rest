////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//class Main {
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/Ingressantes.txt"));
//
//        int atual = Integer.parseInt(br.readLine().split(" ")[0]);
//        ArrayList<List<Integer>> disciplinasList = new ArrayList<>();
//
//        int[] s;
//        while (atual != 0) {
//            for (int i = 0; i < atual; i++) {
//                s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//                Arrays.sort(s);
//                disciplinasList.add(Arrays.stream(s).boxed().collect(Collectors.toList()));
//            }
//            calculateGift(disciplinasList);
//            disciplinasList.clear();
//            atual = Integer.parseInt(br.readLine());
//        }
//    }
//
//    private static void calculateGift(ArrayList<List<Integer>> disciplinasList) {
//        Map<List<Integer>, Long> collect = disciplinasList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Long maxValue = collect.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
//        long count = collect.entrySet()
//                .stream()
//                .filter(entry -> Objects.equals(entry.getValue(), maxValue))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet()).stream().count();
//        System.out.println(maxValue*count);
//    }
//}
