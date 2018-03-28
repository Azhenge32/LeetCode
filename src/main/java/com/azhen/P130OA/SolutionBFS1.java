package com.azhen.P130OA;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Azhen
 * @date 2018/03/12
 */
public class SolutionBFS1 {
    static class Point {
        int row;
        int col;

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.row == p.row && this.col == p.col;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + this.row;
            result = result * 31 + this.col;
            return result;
        }
    }
    public void solve(char[][] board) {
        if (board == null) {
            return ;
        }
        int rows = board.length;
        if (rows <= 0) {
            return ;
        }
        int cols = board[0].length;
        boolean[][] visit = new boolean[rows][cols];
        char[][] boardDist = new char[rows][cols];
        for (int i = 0;i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                boardDist[i][j] = board[i][j];
            }
        }
        // 是地址复制
        // System.arraycopy(board, 0, boardDist, 0, rows);
        int[][] dist = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (visit[i][j]) {
                    continue;
                }
                if (boardDist[i][j] == 'O') {
                    Set<Point> pointSet = new HashSet<>();
                    Queue<Point> queue = new LinkedBlockingQueue();
                    Point point = new Point();
                    point.row = i;
                    point.col = j;
                    queue.add(point);
                    boolean touch = false;
                    while(!queue.isEmpty()) {
                        Point p = queue.poll();
                        visit[p.row][p.col] = true;
                        pointSet.add(p);
                        for (int k = 0; k < 4; k ++) {
                            int[] curr = dist[k];
                            int newC = p.col + curr[0];
                            int newR = p.row + curr[1];
                            if (newC >=0 && newR >=0 && newC < cols && newR < rows) {
                                if (boardDist[newR][newC] == 'O') {
                                    Point p2 = new Point();
                                    p2.row = newR;
                                    p2.col = newC;
                                    if (!pointSet.contains(p2))
                                        queue.add(p2);
                                }
                            } else {
                                touch = true;
                                break ;
                            }
                        }
                    }
                    if (!touch) {
                        for (Point p : pointSet) {
                            board[p.row][p.col] = 'X';
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionBFS1 solution = new SolutionBFS1();
        /*char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };*/
       /*char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };*/
        /*char[][] board = {
                {'X', 'X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'X'}
        };*/
        char[][] board =
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
                };
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
