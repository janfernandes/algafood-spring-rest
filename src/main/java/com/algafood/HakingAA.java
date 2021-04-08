////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//class Main {
//
//    public static Map<Character, Integer> hacking(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray())
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        return map;
//    }
//
//    public static void main(String args[]) throws Exception {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(input.readLine());
//        if (n > 1000) n--;
//        String firstNNumbers = input.lines().limit(n).collect(Collectors.joining());
//        firstNNumbers = firstNNumbers.toUpperCase().replaceAll("[^A-Z]", "");
//        Map<Character, Integer> map = hacking(firstNNumbers);
//        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.<Character, Integer>comparingByValue())
//                .thenComparing(Map.Entry.comparingByKey())).forEach((r) -> System.out.println(r.getKey() + " " + r.getValue()));
//    }
//}
//
