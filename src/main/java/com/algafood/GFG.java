package com.algafood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GFG {
    static int countPiles(int n, int[] a) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int i = 0; i < n; i++)
            occ.put(a[i], occ.get(a[i]) == null ? 1 : occ.get(a[i]) + 1);
        int pile = 0;
        ArrayList<Integer> pileHistory = new ArrayList<>();

        while (!occ.isEmpty()) {
            pile++;
            int size = 0;
            HashSet<Integer> toRemove = new HashSet<>();
            for (HashMap.Entry<Integer, Integer> tm : occ.entrySet()) {
                int mx = tm.getKey();
                int ct = tm.getValue();
                int use = Math.min(ct, mx - size + 1);
                occ.put(mx, occ.get(mx) - use);
                size += use;
                if (occ.get(mx) == 0){
                    toRemove.add(mx);
                    pileHistory.add(mx);
                }
            }
            for (int tm : toRemove)
                occ.remove(tm);
        }
        return pile;
    }

    // Driver Code
    public static void main(String[] args) {
        //UDIASMUFUFACOM
        int[] a = {8, 2, 4, 0, 7, 5, 8, 3, 8, 3, 0, 1, 6, 5};
        int n = a.length;

        System.out.println(countPiles(n, a));
    }
}
