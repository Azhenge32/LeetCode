package com.demo.Search.BinarySearch.P274_h_index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int i = citations.length - 1;
        int h = 0;
        for (; i >= 0; i --) {
            h = citations[i];
            if (citations.length - i >= h) {
                break;
            }
        }
        return Math.min(h, citations.length - i - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations = null;
        citations = new int[]{3,0,6,1,5}; // 3
        System.out.println(solution.hIndex(citations));
        citations = null; // 0
        System.out.println(solution.hIndex(citations));
        citations = new int[]{100}; // 1
        System.out.println(solution.hIndex(citations));
        citations = new int[]{0}; // 0
        System.out.println(solution.hIndex(citations));
    }
}
