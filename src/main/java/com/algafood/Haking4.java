////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
////import java.io.FileReader;
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
//        BufferedReader entrada;
//        //        entrada = new BufferedReader(new InputStreamReader(System.in));
//        entrada = new BufferedReader(new FileReader("c:/casa.txt"));
//        String entradas = entrada.lines().collect(Collectors.joining());
//        //            entradas = entradas.toUpperCase().replaceAll("[^a-zA-Z]", ""); //remove diacritics
//        entradas = entradas.toUpperCase().replaceAll("[\\PL]", ""); // keep diacritics
//        //            entradas = Normalizer.normalize(entradas, Normalizer.Form.NFD).toUpperCase().replaceAll("[^a-zA-Z]", ""); //replace diacritics as valid letters
//        Map<Character, Integer> result = hacking(entradas);
//        result.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.<Character, Integer>comparingByValue()).thenComparing(Map.Entry.comparingByKey())).forEach((r) -> System.out.println(r.getKey() + " " + r.getValue()));
//
//    }
//}
//
