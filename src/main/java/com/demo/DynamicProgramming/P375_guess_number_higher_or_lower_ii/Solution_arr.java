package com.demo.DynamicProgramming.P375_guess_number_higher_or_lower_ii;

public class Solution_arr {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int L = n - 1; L > 0; L --) {
            for (int R = L + 1; R <= n; R ++) {
                dp[L][R] = Integer.MAX_VALUE;
                for (int i = L; i < R; i ++) {
                    // 动态规格，对上一步的结果有依赖
                    dp[L][R] = Math.min(dp[L][R], i + Math.max(dp[L][i - 1], dp[i + 1][R]));
                    show(dp);
                }
            }
        }
        return dp[1][n];
    }

    private void show(int[][] arrs) {
        for (int i = 0; i < arrs.length; i ++) {
            int[] arr = arrs[i];
            for (int j = 0; j < arr.length; j ++) {
                System.out.printf("%d ",arrs[i][j]);
            }
            System.out.println();
        }
        System.out.println("------");
    }

    private static int guess() {
        return 1;
    }

    public static void main(String[] args) {
        Solution_arr solution = new Solution_arr();
        System.out.println(solution.getMoneyAmount(10));
    }
}
