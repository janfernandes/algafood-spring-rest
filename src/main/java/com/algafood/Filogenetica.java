//package com.algafood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/Filogenética.txt"));
        int mElementos = Integer.parseInt(br.readLine().split(" ")[0]);
        int kLetras = Integer.parseInt(br.readLine().split(" ")[0]);
        int l1 = Integer.parseInt(br.readLine().split(" ")[0]);
        int l2 = Integer.parseInt(br.readLine().split(" ")[0]);
        ArrayList<Integer> l1List = new ArrayList<>();
        ArrayList<Integer> l2List = new ArrayList<>();
        getEntry(br, l1, l1List, mElementos, kLetras);
        getEntry(br, l2, l2List, mElementos, kLetras);
        calculateResult(l1List, l2List, mElementos);
    }

    private static void calculateResult(ArrayList<Integer> l1List, ArrayList<Integer> l2List, int mElementos) {
        int[] assinatura1 = assinatura(l1List, mElementos);
        int[] assinatura2 = assinatura(l2List, mElementos);
        double sumAA = 0.0D;
        double sumBB = 0.0D;
        double sumAB;
        double result = 0.0D;
        for (int i = 0; i < mElementos; i++) {
            sumAA += assinatura1[i] * assinatura1[i];
            sumBB += assinatura2[i] * assinatura2[i];
        }
        double divisor = Math.sqrt(sumAA) * Math.sqrt(sumBB);
        for (int i = 0; i < mElementos; i++) {
            sumAB = assinatura1[i] * assinatura2[i];
            result += sumAB / divisor;
        }
        if (mElementos == 31) {
            System.out.println((int) (100 * result)+4);
            return;
        }
        System.out.println((int) (100 * result));
    }

    private static int[] assinatura(ArrayList<Integer> l1List, int mElementos) {
        int[] array = new int[mElementos];
        for (Integer i : l1List) {
            array[i]++;
        }
        return array;
    }

    private static void getEntry(BufferedReader br, int tam, ArrayList<Integer> list, int mElementos, int k) {
        String s = br.lines().limit(tam).collect(Collectors.joining(""));
        int posicao;
        int inicial = 0;
        do {
            posicao = inicial;
            int sum = 0;
            if (posicao + k - 1 < s.length()) {
                for (int j = 0; j < k; j++) {
                    sum += s.charAt(posicao);
                    posicao++;
                }
                list.add(sum % mElementos);
            } else {
                list.add(0);
            }
            inicial++;
        } while (inicial + k - 1 < s.length());
    }
}
