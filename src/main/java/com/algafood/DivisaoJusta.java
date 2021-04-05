//package com.algafood;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static int menorDiferenca(int[] array) {
        int somaTotal = Arrays.stream(array).sum();

        boolean[][] memo = new boolean[array.length + 1][somaTotal + 1];

        for (int index = 0; index <= array.length; index++) {
            memo[index][0] = true;
            for (int soma = 1; index > 0 && soma <= somaTotal; soma++) {
                memo[index][soma] = memo[index - 1][soma];
                if (array[index - 1] <= soma) {
                    memo[index][soma] |= memo[index - 1][soma - array[index - 1]];
                }
            }
        }
        int j = somaTotal / 2;
        while (j >= 0 && !memo[array.length][j]) {
            j--;
        }
        return somaTotal - 2 * j;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int nProblemas = in.nextInt();
        in.nextLine();
        int qntMoedas;
        int valores[];
        String entradas = "";
        int i;
        for (i = 0; i < nProblemas; i++) {
            qntMoedas = in.nextInt();
            in.nextLine();
            if (qntMoedas > 0) {
                String s = in.nextLine();
                entradas = entradas + s;
                valores = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(menorDiferenca(valores));
            } else {
                System.out.println(0);
            }
        }
    }
}
