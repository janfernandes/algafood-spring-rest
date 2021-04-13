package com.algafood;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static Map<String, Integer> counting(List<String> s) {
        Map<String, Integer> map = new HashMap<>();
        for (String c : s)
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }

    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:/cerrado.txt"));
        List<String> collect = br.lines().collect(Collectors.toList());
        Map<String, Integer> map = counting(collect);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((r) -> System.out.println(r.getKey() + " " + String.format("%.4f",r.getValue() / (double) collect.size() * 100)));
    }

}

