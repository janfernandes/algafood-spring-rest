package com.algafood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static class Vertex {

        private int value;
        private boolean beingVisited;
        private boolean visited;
        private List<Vertex> neighbors;

        public Vertex(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Vertex adjacent) {
            this.neighbors.add(adjacent);
        }

        public boolean isBeingVisited() {
            return beingVisited;
        }

        public void setBeingVisited(boolean beingVisited) {
            this.beingVisited = beingVisited;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Vertex> getNeighbors() {
            return neighbors;
        }

        public int getValue() {
            return value;
        }
    }

    public static class Graph {

        private List<Vertex> vertices;

        public Graph() {
            this.vertices = new ArrayList<>();
        }

        public void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        public void addEdge(Vertex from, Vertex to) {
            from.addNeighbor(to);
        }

        public boolean hasCLeanElection(Vertex s) {
            s.setBeingVisited(true);

            for (Vertex neighbor : s.getNeighbors()) {
                if (neighbor.isBeingVisited()) {
                    return true;
                } else if (!neighbor.isVisited() && hasCLeanElection(neighbor)) {
                    return true;
                }
            }

            s.setBeingVisited(false);
            s.setVisited(true);
            return false;
        }

        public boolean hasCLeanElection() {
            for (Vertex vertex : vertices) {
                if (!vertex.isVisited() && hasCLeanElection(vertex)) {
                    return true;
                }
            }
            return false;
        }

        public Vertex getVerticeByLabel(int label) {
            return vertices.stream().filter(v -> label == (v.getValue())).findFirst().orElse(null);
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/Elections.txt"));
        String str;
        while ((!(str = br.readLine()).equals("0"))) {
            int vertices = Integer.parseInt(str.split(" ")[0]);
            Graph graph = new Graph();
            for (int i = 0; i < vertices; i++) {
                graph.addVertex(new Vertex(i));
            }
            int edges = Integer.parseInt(br.readLine().split(" ")[0]);
            String[] s;
            for (int i = 0; i < edges; i++) {
                s = br.readLine().split(" ");
                graph.addEdge(graph.getVerticeByLabel(Integer.parseInt(s[0])), graph.getVerticeByLabel(Integer.parseInt(s[1])));
            }
            System.out.println(graph.hasCLeanElection() ? "PRIMEIRO TURNO." : "SEGUNDO TURNO.");
        }
    }
}
