//package com.algafood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static class Node {
        int n;
        boolean visited;
        Boolean direitista;

        Node(int n) {
            this.n = n;
            visited = false;
        }

        void visit() {
            visited = true;
        }

        public boolean isVisited() {
            return visited;
        }
    }

    public static class Graph {

        private HashMap<Node, LinkedList<Node>> adjacencyMap;

        public Graph() {
            adjacencyMap = new HashMap<>();
        }

        public void addEdgeHelper(Node a, Node b) {
            LinkedList<Node> tmp = adjacencyMap.get(a);

            if (tmp != null) {
                tmp.remove(b);
            } else tmp = new LinkedList<>();
            tmp.add(b);
            adjacencyMap.put(a, tmp);
        }

        public void addEdge(Node source, Node destination) {
            if (!adjacencyMap.keySet().contains(source))
                adjacencyMap.put(source, null);

            if (!adjacencyMap.keySet().contains(destination))
                adjacencyMap.put(destination, null);

            addEdgeHelper(source, destination);
            addEdgeHelper(destination, source);
        }

        boolean breadthFirstSearch(Node node) {
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node currentFirst = queue.removeFirst();
                if (currentFirst.isVisited())
                    continue;

                currentFirst.visit();
                if (currentFirst.direitista == null) currentFirst.direitista = true;
                LinkedList<Node> allNeighbors = adjacencyMap.get(currentFirst);

                if (allNeighbors == null)
                    continue;

                for (Node neighbor : allNeighbors) {
                    if (neighbor.direitista != null && neighbor.direitista == currentFirst.direitista)
                        return false;
                    if (neighbor.direitista == null)
                        neighbor.direitista = !currentFirst.direitista;

                    if (!neighbor.isVisited()) {
                        queue.add(neighbor);
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/Elections.txt"));
        String str;
        int vertices;
        String[] s;
        int edges;
        ArrayList<Node> nodes = new ArrayList<>();
        while ((!(str = br.readLine()).equals("0"))) {
            Graph graph = new Graph();
            vertices = Integer.parseInt(str.split(" ")[0]);
            for (int i = 0; i < vertices; i++) {
                nodes.add(new Node(i));
            }
            edges = Integer.parseInt(br.readLine().split(" ")[0]);
            for (int i = 0; i < edges; i++) {
                s = br.readLine().split(" ");
                graph.addEdge(nodes.get(Integer.parseInt(s[0])), nodes.get(Integer.parseInt(s[1])));
            }
            System.out.println(graph.breadthFirstSearch(nodes.get(0)) ? "SEGUNDO TURNO." : "PRIMEIRO TURNO.");
            nodes.clear();
        }
    }
}