////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//class Main {
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/estacionamento.txt"));
//        String line;
//        ArrayList<String> plates = new ArrayList<>();
//        while ((line = br.readLine()) != null) {
//            plates.add(line);
//        }
//        calculateSpot(plates);
//    }
//
//    private static void calculateSpot(ArrayList<String> plates) {
//        ArrayList<Long> sumsPlates = new ArrayList<>();
//        for (String plate : plates) {
//            long e1 = 0;
//            long e2 = 0;
//            for (int i = 0; i < plate.length() - 1; i++) {
//                e1 += Math.pow((int) plate.charAt(i), 2);
//                e2 += Math.pow((int) plate.charAt(i) + (int) plate.charAt(i + 1), 2);
//            }
//            e1 += Math.pow((int) plate.charAt(plate.length() - 1), 2);
//            sumsPlates.add(e1 + e2);
//        }
//        Set<Long> set = new HashSet<>(sumsPlates);
//        int size = sumsPlates.size();
//        if (set.size() < size) {
//            System.out.println("-1");
//            return;
//        }
//        int platesSize = size;
//        ArrayList<Long> aux = new ArrayList<>();
//        do {
//            for (Long s : sumsPlates) {
//                aux.add(s % size);
//            }
//            set = new HashSet<>(aux);
//            if (set.size() == platesSize) {
//                System.out.println(size);
//                return;
//            }
//            size++;
//            aux.clear();
//        } while (size < 100000);
//    }
//}
