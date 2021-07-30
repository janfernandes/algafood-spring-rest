////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class Main {
//
//    public static class Vertex {
//
//        private int value;
//        private List<Vertex> neighbors;
//        private Boolean direitista;
//
//
//        public Vertex(int value) {
//            this.value = value;
//            this.neighbors = new ArrayList<>();
//        }
//
//        public void addNeighbor(Vertex adjacent) {
//            this.neighbors.add(adjacent);
//        }
//
//        public int getValue() {
//            return value;
//        }
//    }
//
//    public static class Graph {
//
//        private List<Vertex> vertices;
//
//        public Graph() {
//            this.vertices = new ArrayList<>();
//        }
//
//        public void addVertex(Vertex vertex) {
//            this.vertices.add(vertex);
//        }
//
//        public void addEdge(Vertex from, Vertex to) {
//            from.addNeighbor(to);
//        }
//
//        public Vertex getVerticeByLabel(int label) {
//            return vertices.stream().filter(v -> label == (v.getValue())).findFirst().orElse(null);
//        }
//    }
//
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/Elections.txt"));
//        String str;
//        ArrayList<Integer> sourceList = new ArrayList<>();
//        ArrayList<Integer> destList = new ArrayList<>();
//        int vertices;
//        String[] s;
//        int edges;
//        while ((!(str = br.readLine()).equals("0"))) {
//            vertices = Integer.parseInt(str.split(" ")[0]);
//            Graph graph = new Graph();
//            for (int i = 0; i < vertices; i++) {
//                graph.addVertex(new Vertex(i));
//            }
//            edges = Integer.parseInt(br.readLine().split(" ")[0]);
//            for (int i = 0; i < edges; i++) {
//                s = br.readLine().split(" ");
//                sourceList.add(Integer.parseInt(s[0]));
//                destList.add(Integer.parseInt(s[1]));
//            }
//            System.out.println(doAnInstance(graph, sourceList, destList) ? "SEGUNDO TURNO." : "PRIMEIRO TURNO.");
//            sourceList.clear();
//            destList.clear();
//        }
//    }
//
//    private static boolean doAnInstance(Graph graph, ArrayList<Integer> sourceList, ArrayList<Integer> destList) {
//        Vertex source;
//        Vertex dest;
//        for (int i = 0; i < sourceList.size(); i++) {
//            source = graph.getVerticeByLabel(sourceList.get(i));
//            dest = graph.getVerticeByLabel(destList.get(i));
//            if (source.direitista == null) {
//                if (dest.direitista == null) {
//                    source.direitista = Boolean.TRUE;
//                    dest.direitista = Boolean.FALSE;
//                } else {
//                    source.direitista = !dest.direitista;
//                }
//                graph.addEdge(source, dest);
//                graph.addEdge(dest, source);
//            } else {
//                if (dest.direitista == null) {
//                    dest.direitista = !source.direitista;
//                    graph.addEdge(source, dest);
//                    graph.addEdge(dest, source);
//                } else {
//                    if (dest.direitista != source.direitista) {
//                        graph.addEdge(source, dest);
//                        graph.addEdge(dest, source);
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//}
