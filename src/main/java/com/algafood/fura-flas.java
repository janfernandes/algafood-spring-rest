//package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//class Main {
//
//    public static void main(String args[]) throws Exception {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("C:/teste.txt"));
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
//            System.out.println("Caso #" + caso + ":");
//            printCaseX(list);
//            if (fila < n - 1) {
//                System.out.println();
//            }
//            list.clear();
//            caso++;
//        }
////        ArrayList<int[]> teste = new ArrayList<>();
////        teste.add(new int[]{9, 10});
////        teste.add(new int[]{6, 19});
////        teste.add(new int[]{7, 8});
////        teste.add(new int[]{14, 6});
////        teste.add(new int[]{14, 14});
////        teste.add(new int[]{14, 16});
////        teste.add(new int[]{7, 19});
////        teste.add(new int[]{10, 11});
////        printCaseX(teste, 2);
//    }
//
//    private static void printCaseX(ArrayList<int[]> shipList) {
//        int listSize = shipList.size();
//        if (shipList.isEmpty()) {
//            return;
//        }
//        if (listSize == 1) {
//            System.out.println(1);
//            return;
//        }
//        ArrayList<int[]> inParetto = new ArrayList<>();
//        for (int[] ints : shipList) {
//            inParettoList(inParetto, ints);
//            System.out.println(inParetto.size());
//        }
//    }
//
//    private static ArrayList<int[]> inParettoList(ArrayList<int[]> inParetto, int[] possible) {
//        if (inParetto.isEmpty()) {
//            inParetto.add(possible);
//            return inParetto;
//        }
//        int comeco = 0;
//
//        while (comeco < inParetto.size()) {
//            if ((inParetto.get(comeco)[0] < possible[0]) && (inParetto.get(comeco)[1] <= possible[1]) || (inParetto.get(comeco)[0] <= possible[0]) && (inParetto.get(comeco)[1] < possible[1])) {
//                return inParetto;
//            }
//            if ((possible[0] < inParetto.get(comeco)[0]) && (possible[1] <= inParetto.get(comeco)[1]) || (possible[0] <= inParetto.get(comeco)[0]) && (possible[1] < inParetto.get(comeco)[1])) {
//                inParetto.remove(comeco);
//                comeco--;
//            }
//            comeco++;
//        }
//        inParetto.add(possible);
//        return inParetto;
//    }
//}
//
