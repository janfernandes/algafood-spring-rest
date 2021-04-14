package com.algafood;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        char[] charArray = containers.toCharArray();
        Character[] charObjectArray = ArrayUtils.toObject(charArray);
        List<Character> chars = Arrays.asList(charObjectArray);
        Set<Character> hs = new HashSet<>(chars);
        int maxTamQueue = hs.size();
        int result = contar(chars, maxTamQueue);
        printResult(result, currentCase);
    }

    public static Map<Character, Integer> coutingFreq(List<Character> s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s)
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }

    private static int contar(List<Character> chars, int maxTamQueue) {
        List<Character> auxList = new ArrayList<>(chars);
        Collections.reverse(auxList);
        //verificar se é possivel em 1 pilha só - se ta totalmente invertido entao pode
        if (chars.stream().sorted().collect(Collectors.toList()).equals(auxList)) {
            return 1;
        }
        //tentar ate menor q max se nao der para e retorna max
        int stackSize = maxTamQueue;
        List<Character> keepOriginal = new ArrayList<>(chars);
        auxList.clear();
        List<List<Character>> historyStack = new ArrayList<>();
        Map<Character, Integer> characterIntegerMap = coutingFreq(chars);

        for (Character c : chars) {


        }
        return maxTamQueue;
    }

    private static void printResult(int i, int currentCase) {
        System.out.printf("Caso %d: %d \n", currentCase, i);
    }
}

