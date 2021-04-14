package com.algafood;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Box implements Comparable<Box> {
        int height, width, depth, area;

        Box(int h, int w, int d) {
            this.height = h;
            this.width = w;
            this.depth = d;
            this.area = width * depth;
        }

        //helper function to sort boxes accroding to their area
        @Override
        public int compareTo(Box b) {
            return b.area - this.area;
        }
    }

    static int getMaxHeight(int n, Box[] arr) {
        //array to store all rotations of the boxes with original boxes
        Box[] boxes = new Box[n * 3];
        // generate all three rotations of the boxes
        for (int i = 0; i < n; i++) {
            Box curr = arr[i];
            boxes[i * 3] = new Box(curr.height, Math.min(curr.width, curr.depth), Math.max(curr.width, curr.depth));
            boxes[i * 3 + 1] = new Box(curr.width, Math.min(curr.height, curr.depth), Math.max(curr.height, curr.depth));
            boxes[i * 3 + 2] = new Box(curr.depth, Math.min(curr.height, curr.width), Math.max(curr.height, curr.width));
        }
        Arrays.sort(boxes);
        n *= 3;
        //initialize array to store the achievable max height by having box i at the top of the stack
        int maxHeight[] = new int[n];
        for (int i = 0; i < n; i++) maxHeight[i] = boxes[i].height;
        //iterate through all the boxes and update maxHeight using dp
        for (int i = 0; i < n; i++) {
            Box curr = boxes[i];
            int val = 0;
            for (int j = 0; j < i; j++) {
                Box temp = boxes[j];
                if (temp.width > curr.width && temp.depth > curr.depth) val = Math.max(val, maxHeight[j]);
            }
            maxHeight[i] += val;
        }
        //extract the max value from maxHeight and return
        int max = -1;
        for (int i = 0; i < n; i++) max = Math.max(max, maxHeight[i]);
        return max;
    }

    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        System.out.println("The maximum possible " + "height of stack is " + getMaxHeight(4, arr));
    }
}
