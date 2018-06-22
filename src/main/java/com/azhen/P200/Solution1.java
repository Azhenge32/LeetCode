package com.azhen.P200;

public class Solution1 {
    private int ii;
    private int jj;
    char TAG = '1';
    public int numIslands(char[][] board) {
        if (board == null) {
            return 0;
        }
        int rows = board.length;
        if (rows <= 0) {
            return 0;
        }
        int cols = board[0].length;

        char[][] visit = new char[rows][cols];

        int sum = 0;
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (visit[i][j] == 0 && board[i][j] == TAG) {
                    ii = i;
                    jj = j;
                    sum ++;
                    visit[i][j] = 1;
                    visitOther(board, visit, i, j);
                }
            }
        }
        return sum;
    }

    private void visitOther(char[][] board, char[][] visit, int i, int j) {
        try {
            if (i == ii && j == jj) {

            } else if (visit[i][j] == 1) {
                return ;
            }
            if (board[i][j] == TAG) {
                visit[i][j] = 1;
            } else {
                return ;
            }
        } catch (Exception e) {
            return ;
        }

        visitOther(board, visit, i - 1, j);
        visitOther(board, visit, i + 1, j);
        visitOther(board, visit, i, j + 1);
        visitOther(board, visit, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        /*char[][] board = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };*/
        Solution1 solution = new Solution1();
        System.out.println(solution.numIslands(board));
    }
}
