package com.algafood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/cristais.txt"));
        int casesLen = Integer.parseInt(br.readLine().split(" ")[0]);
        if (casesLen == 0) {
            System.out.println(0);
        } else {
            int cristaisSize;
            ArrayList<Set<Integer>> cristaisList = new ArrayList<>();
            cristaisList.add(new HashSet<>());
//            ArrayList<Integer> entrada = new ArrayList<>();
            int cont = 0;
            int value;
            boolean add;
            for (int i = 0; i < casesLen; i++) {
                cristaisSize = Integer.parseInt(br.readLine().split(" ")[0]);
                long[] entrada = new long[cristaisSize];
                for (int c = 0; c < cristaisSize; c++) {
                    value = Integer.parseInt(br.readLine().split(" ")[0]);
//                    add = cristaisList.get(cont).add(value);
                    entrada[c] = value;
//                    if (add == false) {
//                        cont++;
//                        cristaisList.add(new HashSet<>());
//                        cristaisList.get(cont).add(value);
//                    }
                }
//                doACase(cristaisList);
                doACase(entrada);
//                cristaisList.clear();
//                cristaisList.add(new HashSet<>());
//                cont = 0;
            }
        }
    }

    private static void doACase(long[] monoArray) {
        int inf = 0;
        int sup = monoArray.length;
        int maxValue = 0;
        for (int i = inf; i < sup; i++) {
            for (int j = i + 1; j < sup; j++) {
                List<Long> collect = IntStream.range(i, j + 1).mapToObj(v -> monoArray[v]).collect(Collectors.toList());
                System.out.println(collect);
            }
            inf++;
        }
    }

//    private static void doACase(ArrayList<Integer> cristaisList) {
//        ArrayList<Set<Integer>> options = new ArrayList<>();
//        options.add(new HashSet<>());
//        ArrayList<Integer> pote = new ArrayList<>();
//        //for c in range(len(cristais)):
//        for(Integer i : cristaisList){
////            pote.append(cristais[c])
//            pote.add(i);
////            for i in range (c, len(cristais)):
//
//        }
//
//
//        if cristais[i] in pote:
//        result.append(len(pote))
//        break
//       else:
//        pote.append(cristais[i])
//        result.append(len(pote))
//
//
//
//        int size = 0;
//        int atual;
//        for (Set<Integer> e : cristaisList) {
//            atual = e.size();
//            if (size < atual)
//                size = atual;
//        }
//        System.out.println(size);
//    }


//    private static void doACase(ArrayList<Set<Integer>> cristaisList) {
//        int size = 0;
//        int atual;
//        for (Set<Integer> e : cristaisList) {
//            atual = e.size();
//            if (size < atual)
//                size = atual;
//        }
//        System.out.println(size);
//    }
}
