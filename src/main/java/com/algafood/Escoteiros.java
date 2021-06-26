////package com.algafood;
//
//import java.io.*;
//import java.util.*;
//
//class Main {
//    private int vertex;
//    private int e;
//    private Map<Integer, HashSet<Integer>> graph;
//    private static Map<Integer, Integer> visited;
//
//    Main(int vertices) {
//        vertex = vertices;
//        graph = new HashMap<>();
//        visited = new HashMap<>();
//    }
//
//    // Function to add edges
//    private void addEdge(int source, int dest) {
//        graph.putIfAbsent(source, new HashSet<>());
//        graph.putIfAbsent(dest, new HashSet<>());
//        graph.get(source).add(dest);
//        graph.get(source).add(source);
//        graph.get(dest).add(source);
//        graph.get(dest).add(dest);
//        visited.put(source, 0);
//        visited.put(dest, 0);
//    }
//
//    private void findPath(int vertex) {
//        visited.put(vertex, 1);
//        for (Integer child : graph.get(vertex)) {
//            if (visited.get(child) == 0) {
//                findPath(child);
//            }
//        }
//    }
//
//    // Driver Code
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/Escoteiros.txt"));
//        int cases = Integer.parseInt(br.readLine().split(" ")[0]);
//        String vertices;
//        String str;
//        br.readLine();
//        String maior;
//        boolean firstTime = true;
//        for (int j = 0; j < cases; j++) {
//            maior = br.readLine();
//            vertices = addAteMaior(maior);
//            while (((str = br.readLine()) != null && str.length() != 0 && str != "")) {
//                vertices += str;
//            }
//            if (!firstTime)
//                System.out.println();
//            groupsNumber(vertices);
//            firstTime = false;
//        }
//    }
//
//    private static String addAteMaior(String maior) {
//        String vertices = "";
//        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
//        int i = 0;
//        while (!maior.equals(alphabet[i])) {
//            vertices += alphabet[i] + alphabet[i];
//            i++;
//        }
//
//        vertices += maior + maior;
//        return vertices;
//    }
//
//    private static void groupsNumber(String vertices) {
//        char[] ch = vertices.toCharArray();
//        HashSet<Character> hs = new HashSet<>();
//        for (char each : ch) {
//            hs.add(each);
//        }
//        Main escoteiros = new Main(hs.size());
//        for (int i = 0; i < vertices.length(); i += 2) {
//            escoteiros.addEdge(vertices.charAt(i), vertices.charAt(i + 1));
//        }
//        int escoteirosCount = 0;
//        for (Integer vertex : visited.keySet()) {
//            if (visited.get(vertex) == 0) {
//                escoteiros.findPath(vertex);
//                escoteirosCount++;
//            }
//        }
//
//        System.out.println(escoteirosCount);
//    }
//}
