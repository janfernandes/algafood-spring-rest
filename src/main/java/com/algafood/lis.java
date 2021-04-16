
package com.algafood;

import java.util.Arrays;

public class lis {
    static int findPossibilitiesToQueue(int arr[], int tam) {
        int memo[] = new int[tam + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = Integer.MIN_VALUE;

        for (int i = 0; i < tam; i++) {
            int index = finding(memo, arr[i]);
            if (index != -1)
                memo[index] = Math.min(memo[index], arr[i]);
        }
        int len = 0;
        for (int i = 1; i <= tam; i++) {
            if (memo[i] != Integer.MAX_VALUE)
                len = Math.max(i, len);
        }
        return len;
    }

    static int finding(int dp[], int num) {

        int inf = 0, sup = dp.length - 1;
        int ans = -1;
        while (inf <= sup) {
            int mid = inf + (sup - inf) / 2;
            if (dp[mid] >= num) {
                ans = mid;
                sup = mid - 1;
            } else
                inf = mid + 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        int a[] = {3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2};
//        for (int i = 0; i < a.length; i++)
//            a[i] = -a[i];

        int[] vetor = new int[14];
        char[] chars = "UDIASMUFUFACOM".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            vetor[i] = Character.getNumericValue(chars[i]);
        }
        System.out.print(findPossibilitiesToQueue(vetor, vetor.length));
    }
}

