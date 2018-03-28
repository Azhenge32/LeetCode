package com.azhen.P130OA;

/**
 * 1、从四条边开始，找到所有“触边”的'0'块,并赋值为1
 * 2、把没有触边的’0'变成X
 * 3、把1还原成0
 */
public class SolutionBFS2 {
    private char[][] board;
    private int rows;
    private int cols;
    public void solve(char[][] board) {
        this.board = board;
        if (board == null) {
            return ;
        }
        rows = board.length;
        if (rows <= 0) {
            return ;
        }
        cols = board[0].length;

        for (int i = 0; i < rows; i ++) {
            check(i, 0);
            check(i, cols - 1);
        }
        for (int j = 0; j < cols; j ++) {
            check(0, j);
            check(rows - 1, j);
        }

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (board[i][j] =='O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (board[i][j] =='1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void check(int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 0) {
                check(i - 1, j);
            }
            if (j > 0) {
                check(i, j - 1);
            }
            if (i < rows - 1) {
                check(i + 1, j);
            }
            if (j < cols - 1) {
                check(i, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        SolutionBFS2 solution = new SolutionBFS2();
        /*char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };*/
       char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };
        /*char[][] board = {
                {'X', 'X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'X'}
        };*/
        /*char[][] board =
                {
                        {'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                        {'O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','X','X'},
                        {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','X'},
                        {'O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                        {'O','O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','X','O','O','X'},
                        {'X','O','O','O','X','O','O','O','O','O','X','O','X','O','X','O','X','O','X','O'},
                        {'O','O','O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O'},
                        {'X','O','O','O','X','X','X','O','X','O','O','O','O','X','X','O','X','O','O','O'},
                        {'O','O','O','O','O','X','X','X','X','O','O','O','O','X','O','O','X','O','O','O'},
                        {'X','O','O','O','O','X','O','O','O','O','O','O','X','X','O','O','X','O','O','X'},
                        {'O','O','O','O','O','O','O','O','O','O','X','O','O','X','O','O','O','X','O','X'},
                        {'O','O','O','O','X','O','X','O','O','X','X','O','O','O','O','O','X','O','O','O'},
                        {'X','X','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                        {'O','X','O','X','O','O','O','X','O','X','O','O','O','X','O','X','O','X','O','O'},
                        {'O','O','X','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','X','O'},
                        {'X','X','O','O','O','O','O','O','O','O','X','O','X','X','O','O','O','X','O','O'},
                        {'O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O','O'},
                        {'O','O','O','X','O','O','O','O','O','X','X','X','O','O','X','O','O','O','X','O'},
                        {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                        {'X','O','O','O','O','X','O','O','O','X','X','O','O','X','O','X','O','X','O','O'}
                };*/
        solution.solve(board);

        for (char[] arr : board) {
            for (char c : arr) {
                System.out.printf("%c ", c);
            }
            System.out.println();
        }

        /*Point p1 = new Point();
        p1.col = 1;
        p1.row = 1;

        Point p2 = new Point();
        p2.col = 1;
        p2.row = 1;
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1 == p2);*/

        /*Set<SolutionBFS1> set = new HashSet<>();
        SolutionBFS1 p1 = new SolutionBFS1();
        p1.col = 1;
        p1.row = 1;
        set.add(p1);

        SolutionBFS1 p2 = new SolutionBFS1();
        p2.col = 1;
        p2.row = 1;
        System.out.println(set.contains(p2));
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1 == p2);*/
    }

}
