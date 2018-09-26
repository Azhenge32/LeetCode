package com.demo.DynamicProgramming.P375_guess_number_higher_or_lower_ii;

public class Solution {
    public int getMoneyAmount(int n) {
        int low = 1;
        int high = n;
        int sum = 0;
        int mid = 0;
        while (low <= high) {
            int dis = high - low;
            if (dis == 0) {
                mid = 0;
            } else if (dis == 1) {
                mid = low;
            } else if (dis == 2) {
                mid = low + (high - low) / 2;
            } else if (dis == 3) {
                mid = low;
            } else if (dis == 4) {
                mid = low + 1;
            } else {
                mid = low + (high - low) / 2;
            }
            sum += mid;
            if (mid == 0) {
                return sum;
            } else {
                low = mid + 1;
            }
        }
        return sum;
    }

    private static int guess() {
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ii = null;
        ii = new int[]{1};// 0
        ii = new int[]{1, 2};// 1
        ii = new int[]{1, 2, 3};//2
        ii = new int[]{1, 2, 3, 4};//1+3 = 4
        ii = new int[]{1, 2, 3, 4, 5};//2 + 4 = 6
        ii = new int[]{1, 2, 3, 4, 5, 6};
        ii = new int[]{1, 2, 3, 4, 5, 6, 7};
        ii = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ii = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};      //  =14
        ii = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //5 + 7 + 9=21
        System.out.println(solution.getMoneyAmount(1));
        System.out.println(solution.getMoneyAmount(2));
        System.out.println(solution.getMoneyAmount(3));
        System.out.println(solution.getMoneyAmount(4));
        System.out.println(solution.getMoneyAmount(5));
        System.out.println(solution.getMoneyAmount(9));
        System.out.println(solution.getMoneyAmount(10));
    }
}
