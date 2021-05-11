package com.algafood;

import java.util.PriorityQueue;

class Lis {
    static int findLongestConseqSubseq(int arr[], int N) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(arr[i]);
        }
        int prev = pq.poll();
        int c = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {
            if (pq.peek() - prev > 1) {
                c = 1;
                prev = pq.poll();
            }
            else if (pq.peek() - prev == 0) {
                prev = pq.poll();
            }
            else {
                c++;
                prev = pq.poll();
            }
            if (max < c) {
                max = c;
            }
        }

        return max;
    }

    // Driver Code
    public static void main(String args[]) {
        int arr[] = {1,2,3,2,4,5};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
    }
}
