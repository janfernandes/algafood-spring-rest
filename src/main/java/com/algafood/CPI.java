////package com.algafood;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//class Main {
//    public static class Vertex {
//
//        private int value;
//        private boolean beingVisited;
//        private boolean visited;
//        private List<Vertex> neighbors;
//        private boolean incoming;
//        private boolean outgoing;
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
//        public void setBeingVisited(boolean beingVisited) {
//            this.beingVisited = beingVisited;
//        }
//
//        public void setVisited(boolean visited) {
//            this.visited = visited;
//        }
//
//        public List<Vertex> getNeighbors() {
//            return neighbors;
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
//        public void hasCLeanElection(Vertex s) {
//            s.setBeingVisited(true);
//            if (!s.getNeighbors().isEmpty()) {
//                s.outgoing = true;
//            }
//            for (Vertex neighbor : s.getNeighbors()) {
//                neighbor.incoming = true;
//                hasCLeanElection(neighbor);
//            }
//            s.setBeingVisited(false);
//            s.setVisited(true);
//        }
//
//        private void passGraph() {
//            for (Vertex vertex : vertices) {
//                hasCLeanElection(vertex);
//            }
//        }
//
//        public void printDepoentes() {
//            passGraph();
//            ArrayList<Integer> primeiros = new ArrayList<>();
//            ArrayList<Integer> ultimos = new ArrayList<>();
//            for (Vertex v : vertices) {
//                if (v.outgoing && v.incoming) {
//                    continue;
//                }
//                if (!v.incoming) {
//                    primeiros.add(v.value);
//                }
//                if (!v.outgoing) {
//                    ultimos.add(v.value);
//                }
//            }
//            Collections.sort(primeiros);
//            Collections.sort(ultimos);
//            primeiros.forEach(result -> System.out.print(result + " "));
//            System.out.println();
//            ultimos.forEach(result -> System.out.print(result + " "));
//            System.out.println();
//        }
//
//        public Vertex getVerticeByLabel(int label) {
//            return vertices.stream().filter(v -> label == (v.getValue())).findFirst().orElse(null);
//        }
//    }
//
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/CPI.txt"));
//        String str;
//        while ((!(str = br.readLine()).equals("0 0"))) {
//            int n = Integer.parseInt(str.split(" ")[0]);
//            Graph graph = new Graph();
//            for (int i = 1; i < n + 1; i++) {
//                graph.addVertex(new Vertex(i));
//            }
//            int m = Integer.parseInt(str.split(" ")[1]);
//            String[] s;
//            for (int i = 0; i < m; i++) {
//                s = br.readLine().split(" ");
//                graph.addEdge(graph.getVerticeByLabel(Integer.parseInt(s[0])), graph.getVerticeByLabel(Integer.parseInt(s[1])));
//            }
//            graph.printDepoentes();
//        }
//    }
//}