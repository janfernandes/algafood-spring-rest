//package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//class Main {
//
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int tamFila;
//        int a[];
//        int caso = 1;
//        ArrayList<int[]> list = new ArrayList<>();
//        for (int fila = 0; fila < n; fila++) {
//            tamFila = Integer.parseInt(br.readLine());
//            for (int navio = 0; navio < tamFila; navio++) {
//                a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//                list.add(a);
//            }
//            printCaseX(list, caso);
//            list = null;
//            caso++;
//        }
//    }
//
//    private static void printCaseX(ArrayList<int[]> shipList, int caso) {
//        System.out.println("Caso #%d" + caso);
//        int listSize = shipList.size();
//        int parettoSize = 1;
//        if (shipList.size() == 0) {
//            System.out.println(0);
//            return;
//        }
//        if (listSize == 1) {
//            System.out.println(parettoSize);
//            return;
//        }
//        for (int i=0; i< listSize; i++) {
//            System.out.println(parettoSize);
//            if (isItInParetto(shipList.get(i))){
//                parettoSize++;
//            }
//        }
//    }
//
//    private static boolean isItInParetto(int[] ints) {
//        return false;
//    }
//}
//
