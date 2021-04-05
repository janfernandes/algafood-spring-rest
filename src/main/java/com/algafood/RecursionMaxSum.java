package com.algafood;

public class RecursionMaxSum {
    static int maxSum(int[] A, int i) {
        if (i == 0) {
            return Math.max(0, A[i]);
        }
        return Math.max(maxSum(A, i - 1) + A[i], 0);
        // Compara a 0, pois se eu tenho valores negativos, qualquer
        // valor sozinho somado será inferior à ele próprio então deve
        // iniciar novamente
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 6, 3, 2, -12, -6, 7, 1};
        int pos = a.length - 1;
        System.out.println(maxSum(a, pos));// Returns 16, expected 11
    }
}
