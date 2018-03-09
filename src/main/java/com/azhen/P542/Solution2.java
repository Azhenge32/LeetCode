package com.azhen.P542;

import java.util.ArrayList;
import java.util.List;

/**
 * 01 Matrix
 */
public class Solution2 {
    class Point {
        int x;
        int y;
    }
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length < 0) {
            return matrix;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] matrixDist = new int[height][width];

        List<Point> zeroList = new ArrayList<>();
        List<Point> nzeroList = new ArrayList<>();
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                Point point = new Point();
                point.x = i;
                point.y = j;
                if (matrix[i][j] == 0) {
                    matrixDist[i][j] = 0;
                    zeroList.add(point);
                } else {
                    nzeroList.add(point);
                    matrixDist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (Point nz : nzeroList) {
            for (Point z : zeroList) {
                int x = Math.abs(z.x - nz.x);
                int y = Math.abs(z.y - nz.y);
                if (x + y < matrixDist[nz.x][nz.y]) {
                    matrixDist[nz.x][nz.y] = x + y;
                }
            }
        }

        return matrixDist;
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
        Solution2 solution = new Solution2();
        matrix = solution.updateMatrix(matrix);
        for (int[] arr : matrix) {
            for(int a : arr) {
                System.out.printf("%d,", a);
            }
            System.out.println();
        }
    }
}
