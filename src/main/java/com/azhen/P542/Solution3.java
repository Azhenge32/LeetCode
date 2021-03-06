package com.azhen.P542;

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
        int[][] dist = new int[height][width];
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    Point point = new Point(j,i);
                    queue.add(point);
                }
            }
        }

        // 遍历方向
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int i = 0; i < 4; i ++) {
                int newX = curr.x + dir[i][0], newY = curr.y + dir[i][1];
                if (newX >=0 && newY >=0 && newX < width && newY < height) {
                    if (dist[newY][newX] > dist[curr.y][curr.x] + 1) { // 添加队列规则
                        dist[newY][newX] = dist[curr.y][curr.x] + 1;
                        Point point = new Point(newX, newY);
                        queue.add(point);   // 添加到对BFS队列
                    }
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
