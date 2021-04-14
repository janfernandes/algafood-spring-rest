//package com.algafood;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class lis {
//    public static List<Character> encontrarPossibilidadePilha(char[] arr) {
//        List<List<Character>> LDS = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            LDS.add(new ArrayList<>());
//        }
//        LDS.get(0).add(arr[0]);
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j] >= arr[i] && LDS.get(j).size() > LDS.get(i).size()) {
//                    LDS.set(i, new ArrayList<>(LDS.get(j)));
//                }
//            }
//            LDS.get(i).add(arr[i]);
//        }
//        int j = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (LDS.get(j).size() < LDS.get(i).size()) {
//                j = i;
//            }
//        }
//        return LDS.get(j);
//    }
//
//    public static void main(String[] args) {
//        char[] arr = "UDIASMUFUFACOM".toCharArray();
//        encontrarPossibilidadePilha(arr);
//    }
//}
