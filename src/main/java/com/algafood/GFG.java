//package com.algafood;
//
//import java.util.HashMap;
//
//class GFG {
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
//    }
//
//    // Driver code
//    public static void main(String ars[]) {
//        char pre[] = {'S', 'E', 'A', 'H', 'T', 'P'};
//        char in[] = {'A', 'E', 'H', 'S', 'T', 'P'};
//        GFG tree = new GFG();
//        tree.findPostTree(in, pre);
//    }
//}
