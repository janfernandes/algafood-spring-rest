//package com.algafood;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//class Main {
//
//    class Elem {
//        char ch;
//        int freq;
//    }
//
//    static class BSTnode {
//        char data;
//        int cnt;
//        BSTnode left, right;
//    }
//
//    boolean comp(Elem a, Elem b) {
//        if (a.freq != b.freq) return a.freq > b.freq;
//        else return a.ch < b.ch; //Character.toLowerCase(a) < Character.toLowerCase(b)
//    }
//
//    int[] sortByFrequency(char S[], int n) {
//        BSTnode root = null;
//        BSTnode temp = null;
//        for (int i = 0; i < n - 1; i++) {
//            Elem temp = BSTsearch(root, S[i]);
//            if (temp != null) temp.freq = temp.freq + 1;
//            else if (temp == null) {
//                BSTnode node = new BSTnode();
//                node.data = S[i];
//                node.cnt = 1;
//                node.left = node.right = null;
//                BSTinsert(root, node);
//            }
//        }
//        Elem freq_arr[];
//        inorderStore(root, freq_arr); //Extracting Characters from BST to freq_arr[] using in-order traversal
//        sort(freq_arr, freq_arr.length, comp);
//        char ans[] = new char[26];
//        for (int i = 0; i < freq_arr.length - 1; i++){
//            for (j = 0; i< freq_arr[i].freq - 1; i++){
//                ans.append(freq_arr[i].ch);
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String args[]) throws Exception {
//        Scanner in = new Scanner(System.in);
//        int nProblemas = in.nextInt();
//        in.nextLine();
//        String entradas = "";
//        for (int i = 0; i < nProblemas; i++) {
//            entradas = entradas.concat(in.nextLine().toUpperCase()).replaceAll("[^a-zA-Z]", "");
//        }
//        ArrayList<Character> chars = new ArrayList<>(entradas.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
//        String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        for (char c : alfa.toCharArray()) {
//            System.out.println(c + " " + countOccurrences(chars, c));
//        }
//        //        Map<String, Integer> result = hack(entradas);
//        //        result.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach((r) -> System.out.println(r.getKey() + " " + r.getValue()));
//        //        String r for (Map.Entry<String, Integer> entry : result.entrySet()) {
//        //            System.out.println(entry.getKey() + " " + entry.getValue());
//        throw new Exception("entrou");
//    }
//}
//
