////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class Main {
//
//    public static Map<String, Integer> counting(List<String> s) {
//        Map<String, Integer> map = new HashMap<>();
//        for (String c : s)
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        return map;
//    }
//
//    public static void main(String args[]) throws Exception {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("C:/cerrado.txt"));
//        int n = Integer.parseInt(br.readLine());
//        String currentLine;
//        List<String> collect = new ArrayList<>();
//        Map<String, Integer> map;
//        boolean first = false;
//        while ((currentLine = br.readLine()) != null) {
//            if (!currentLine.trim().isEmpty()) {
//                collect.add(currentLine);
//                first = true;
//            } else if (first) {
//                map = counting(collect);
//                map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((r) -> System.out.println(r.getKey() + " " + String.format("%.4f", r.getValue() / (double) collect.size() * 100)));
//                collect.clear();
//                System.out.println();
//            }
//        }
//        map = counting(collect);
//        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((r) -> System.out.println(r.getKey() + " " + String.format("%.4f", r.getValue() / (double) collect.size() * 100)));
//    }
//}
//
