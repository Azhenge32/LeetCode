package com.azhen.P200;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    class UF {
         int[] id;
        int[] size;
        private int count;

        public UF(int n) {
            count = n;
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i ++) {
                id[i] = i;
                size[i] = 0;
            }
        }

        /**
         * 查找数的根结点
         * @param p
         * @return
         */
        int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        int getCount() {
            return count;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) {
                return ;
            }

            // 确保小树合并到大树
            if (size[i] < size[j]) {
                id[i] = j;
            } else if (size[i] > size[j]) {
                id[j] = i;
            } else {
                id[j] = i;
                size[i]++;
            }
            count --;
        }
    }

    public int numIslands(char[][] board) {
        if (board == null) {
            return 0;
        }
        int rows = board.length;
        if (rows <= 0) {
            return 0;
        }
        int cols = board[0].length;

        UF uf = new UF(rows * cols);

        print(uf, cols);

        System.out.println("--------------");

        char TAG = '1';
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (board[i][j] == TAG) {
                    union(uf, TAG, board, i, j , i - 1, j);
                    union(uf, TAG, board, i, j , i + 1, j);
                    union(uf, TAG, board, i, j , i, j - 1);
                    union(uf, TAG, board, i, j , i, j + 1);

                    print(uf, cols);
                }
            }
        }

        char OTAG = '0';
        int sum = 0;
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (board[i][j] == OTAG) {
                    sum ++;
                }
            }
        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < uf.id.length; i ++) {
            if (uf.find(i) == i) {
                set.add(i);
            }
        }

        return set.size() - sum;
    }

    private void union(UF uf, char TAG, char [][]board, int sI, int sJ, int tI, int tJ) {
        int cols = board[0].length;
        try {
            if (board[tI][tJ] == TAG) {
                uf.union(sI * cols + sJ, tI * cols + tJ);
            }
        } catch (Exception e) {
        }
    }

    private void print(UF uf, int cols) {
        System.out.println("-------------");
        int p = 0;
        for (int i = 0; i < uf.id.length; i ++) {
            System.out.printf( "%d ", uf.id[i]);
            p ++;
            if (p == cols) {
                System.out.println();
                p = 0;
            }
        }
    }

    public static void main(String[] args) {
        /*char[][] board = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };*/
        /*char[][] board = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };*/
        char[][] board = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'},
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(board));
    }
}
