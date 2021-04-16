package com.algafood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String args[]) throws Exception {
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //        String collect = "";
        //        String line = br.readLine();
        //        while ((line != null) && (!line.isEmpty())) {
        //            collect = collect + line + "-";
        //            line = br.readLine();
        //        }
        //        throw new Exception(collect);
        BufferedReader br = new BufferedReader(new FileReader("C:/Cargueiros.txt"));
        String currentLine;
        int currentCase = 0;
        while (!(currentLine = br.readLine()).equals("fim")) {
            currentCase++;
            toQueueItsBestWay(currentLine, currentCase);
        }
    }

    private static void toQueueItsBestWay(String containers, int currentCase) {
        if (containers.length() == 1) {
            printResult(1, currentCase);
            return;
        }
        int maxQueueSize = getUniqueSize(containers);

        int tamQueue = 0;
        List<Character> possibilitiesToQueue = findPossibilitiesToQueue(containers.toCharArray());
        while (!possibilitiesToQueue.isEmpty()) {
            if(tamQueue==maxQueueSize){
                break;
            }
            tamQueue++;
            int start = containers.indexOf(possibilitiesToQueue.get(0));
            int fim = containers.length();
            String auxSearch = containers.substring(start, fim);
            for (Character c : possibilitiesToQueue) {
                for (int i = start; i < containers.length(); i++) {
                    if (auxSearch.charAt(i) == c) {
                        auxSearch = auxSearch.substring(0, i) + auxSearch.substring(i + 1);
                        start = i;
                        break;
                    }
                }
            }
            containers = auxSearch;
            if (containers.isEmpty()) break;
            possibilitiesToQueue = findPossibilitiesToQueue(containers.toCharArray());
        }
        printResult(Math.min(tamQueue, maxQueueSize), currentCase);
    }

    public static List<Character> findPossibilitiesToQueue(char[] arr) {
        List<List<Character>> sequence = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sequence.add(new ArrayList<>());
        }
        //depois q mudar da letra inicial ja pode parar
        sequence.get(0).add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //esta errado aqui
                if (arr[j] >= arr[i]) {
                    sequence.set(i, new ArrayList<>(sequence.get(j)));
                }
            }
            sequence.get(i).add(arr[i]);
        }
        int novo = 0;
        for (int atual = 0; atual < arr.length; atual++) {
            if (sequence.get(atual).get(0) == arr[0] && sequence.get(novo).size() < sequence.get(atual).size()) {
                novo = atual;
            }
        }
        return sequence.get(novo);
    }

    static int getUniqueSize(String str) {
        Set<Character> lhs = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++)
            lhs.add(str.charAt(i));

        return lhs.size();
    }

    private static void printResult(int i, int currentCase) {
        System.out.printf("Caso %d: %d \n", currentCase, i);
    }
}
