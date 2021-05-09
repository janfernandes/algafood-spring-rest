//package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class Main {
//    public static void main(String args[]) throws Exception {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/cristais.txt"));
//        int casesLen = Integer.parseInt(br.readLine().split(" ")[0]);
//
//        int cristaisSize;
//        ArrayList<Set<Integer>> cristaisList = new ArrayList<>();
//        cristaisList.add(new HashSet<>());
//        int cont = 0;
//        int value;
//        boolean add;
//        for (int i = 0; i < casesLen; i++) {
//            cristaisSize = Integer.parseInt(br.readLine().split(" ")[0]);
//            for (int c = 0; c < cristaisSize; c++) {
//                value = Integer.parseInt(br.readLine().split(" ")[0]);
//                add = cristaisList.get(cont).add(value);
//                if (add == false) {
//                    cont++;
//                    cristaisList.add(new HashSet<>());
//                    cristaisList.get(cont).add(value);
//                }
//            }
//            doACase(cristaisList);
//            cristaisList.clear();
//            cristaisList.add(new HashSet<>());
//            cont = 0;
//        }
//    }
//
//    private static void doACase(ArrayList<Set<Integer>> cristaisList) {
//        int size = 0;
//        int atual;
//        for (Set<Integer> e : cristaisList) {
//            atual = e.size();
//            if (size < atual)
//                size = atual;
//        }
//        System.out.println(size);
//    }
//}
