//package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//class Main {
//    static int preIndex = 0;
//
//    void printPostArvore(char[] emCaminho, char[] preCaminho, int inStrt, int inEnd, HashMap<Character, Integer> hashMapArvore) {
//        if (inStrt > inEnd)
//            return;
//
//        int emCaminhoIndex = hashMapArvore.get(preCaminho[preIndex++]);
//        printPostArvore(emCaminho, preCaminho, inStrt, emCaminhoIndex - 1, hashMapArvore);
//        printPostArvore(emCaminho, preCaminho, emCaminhoIndex + 1, inEnd, hashMapArvore);
//
//        System.out.print(emCaminho[emCaminhoIndex]);
//    }
//
//    void findPostTree(char[] emCaminho, char[] preCaminho) {
//        int n = preCaminho.length;
//        HashMap<Character, Integer> hashMapArvore = new HashMap<>();
//        for (int i = 0; i < n; i++)
//            hashMapArvore.put(emCaminho[i], i);
//        printPostArvore(emCaminho, preCaminho, 0, n - 1, hashMapArvore);
//        System.out.println();
//    }
//
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        Main tree = new Main();
//        String line = br.readLine();
//        String[] split;
//        while ((line != null) && (!line.isEmpty())) {
//            split = line.split("\\s+");
//            tree.findPostTree(split[1].toCharArray(), split[0].toCharArray());
//            line = br.readLine();
//            preIndex = 0;
//        }
//    }
//}
