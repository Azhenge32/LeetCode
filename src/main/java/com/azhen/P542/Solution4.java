package com.azhen.P542;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * BFS
 */
public class Solution4 {
    private int height;
    private int width;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length < 0) {
            return matrix;
        }
        height = matrix.length;
        width = matrix[0].length;
        int[][] dist = new int[height][width];
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                dist[i][j] = Integer.MAX_VALUE - 10000;
            }
        }

        // 左上角
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                if(matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = height - 1; i >=0; i --) {
            for (int j = width - 1; j >=0; j --) {
                if (i < height - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j < width - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }

        return dist;
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
        Solution4 solution = new Solution4();
        matrix = solution.updateMatrix(matrix);
        for (int[] arr : matrix) {
            for(int a : arr) {
                System.out.printf("%d,", a);
            }
            System.out.println();
        }
    }
}
