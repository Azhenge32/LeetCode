package com.azhen.P542;
/**
 * 01 Matrix
 */
public class Solution1 {
    /** 0:未访问 1:已访问未有值 2:已有值  */
    private int[][] matrixFlag;
    private int[][] matrixDepth;
    private int height;
    private int width;
    private int srcX;
    private int srcY;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length < 0) {
            return matrix;
        }
        height = matrix.length;
        width = matrix[0].length;
        matrixFlag = new int[height][width];

        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                if (matrixFlag[i][j] == 2) {
                    continue;
                }
                distince(matrix, i, j);
            }
        }
        return matrix;
    }

    private int distince(int[][] matrix, int x, int y) {
        matrixFlag[x][y] = 1;
        if (matrix[x][y] == 0) {
            matrixFlag[x][y] = 2;
            return 0;
        }

        if (matrixFlag[x][y] == 2) {
            return matrix[x][y];
        }

        int result = 100;
        // 左边
        if (x - 1 >= 0 && matrixFlag[x - 1][y] != 1) {
            result = visit(matrix, x - 1, y, result);
        }
        // 上边
        if (y - 1 >= 0 && matrixFlag[x][y - 1] != 1) {
            result = visit(matrix, x, y - 1, result);
        }
        // 右边
        if (x + 1 < width && matrixFlag[x + 1][y] != 1) {
            result = visit(matrix, x + 1, y, result);
        }
        // 下边
        if (y + 1 < height && matrixFlag[x][y + 1] != 1) {
            result = visit(matrix, x, y + 1, result);
        }

        matrix[x][y] = result;
        matrixFlag[x][y] = 2;
        return result;
    }

    private int visit(int[][] matrix, int x, int y, int result) {
        int distance = height * width;
        if (matrixFlag[x][y] == 1) {
        } else if(matrixFlag[x][y] == 2) {
            distance =  matrix[x][y];
        } else if (matrixFlag[x][y] == 0) {
            distance = distince(matrix, x, y);
        }
        if (distance + 1 < result) {
            result = distance + 1;
        }
        return result;
    }

    private boolean preReady() {
        return matrixFlag[srcX][srcY] == 1;
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
        Solution1 solution = new Solution1();
        solution.updateMatrix(matrix);
        for (int[] arr : matrix) {
            for(int a : arr) {
                System.out.printf("%d,", a);
            }
            System.out.println();
        }
    }
}
