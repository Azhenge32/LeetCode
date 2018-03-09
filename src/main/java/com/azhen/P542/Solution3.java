package com.azhen.P542;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * BFS
 */
public class Solution3 {
    private int height;
    private int width;
    class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length < 0) {
            return matrix;
        }
        height = matrix.length;
        width = matrix[0].length;
        int[][] matrixDist = new int[height][width];

        Queue<Point> queue = new LinkedBlockingDeque<>();
        Point point = new Point(0, 0);
        queue.add(point);
        while (!queue.isEmpty()) {
            Point head = queue.poll();

        }

        return matrixDist;
    }

    private void findNearZero(int[][] matrix, Queue<Point> queue, int x, int y) {
        int depth = 0;
        while (matrix[x][y] != 0) {
            depth = 1;
            if (xValid(x - depth)) {
                findNearZero(matrix, queue, x - depth, y);
            } else if (yValid(y - depth)) {
                findNearZero(matrix, queue, y - depth, y);
            } else if (xValid(x + depth)) {
                findNearZero(matrix, queue, x + depth, y);
            } else if (yValid(y + depth)) {
                findNearZero(matrix, queue, y + depth, y);
            }
        }
    }

    private boolean xValid(int x) {
        return x >=0 && x < width;
    }

    private boolean yValid(int y) {
        return y >=0 && y < height;
    }

    public static void main(String[] args) {
        /*int[][] matrix = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };*/
        int[][] matrix = {
                {1,1,0},
                {1,1,1},
                {1,1,1}
        };
      /* int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };*/
        /*int[][] matrix = {
                {1,1},
                {1,0}
        };*/
        /*int[][] matrix = {
                {0,1},
                {1,1}
        };*/
        /*int[][] matrix = {
                {1,0},
                {1,1}
        };*/
        /*int[][] matrix = {
                {1,1},
                {0,1}
        };*/
        Solution3 solution = new Solution3();
        matrix = solution.updateMatrix(matrix);
        for (int[] arr : matrix) {
            for(int a : arr) {
                System.out.printf("%d,", a);
            }
            System.out.println();
        }
    }
}
