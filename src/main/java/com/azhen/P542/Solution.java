package com.azhen.P542;
/**
 * 01 Matrix
 */
public class Solution {
    private int[][] matrixFlag;
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
                if (matrixFlag[i][j] == 1) {
                    continue;
                }
                distince(matrix, i, j);
            }
        }
        return matrix;
    }

    private int distince(int[][] matrix, int x, int y) {
        if (matrix[x][y] == 0) {
            matrixFlag[x][y] = 1;
            return 0;
        }
        if (matrixFlag[x][y] == 1) {
            return matrix[x][y];
        }

        Integer result = null;
        int tmpX = srcX;
        int tmpY = srcY;
        // 左边
        if (x - 1 >= 0) {
            int distince = 0;
            if (matrixFlag[x - 1][y] == 1 ) {
                distince = matrix[x - 1][y];
            } else if (x - 1 != srcX) {
                distince = distince(matrix, x - 1, y) + 1;
            }
            if (result == null){
                result = distince;
                if (result == 1) {
                    matrix[x][y] = result;
                    matrixFlag[x][y] = 1;
                    return result;
                }
            }
        }
        srcX = tmpX;
        // 上边
        if (y - 1 >= 0) {
            int distince = 0;
            if (matrixFlag[x][y - 1] == 1 ) {
                distince = matrix[x][y-1];
            } else if ( y - 1 != srcY ) {
                distince = distince(matrix, x, y - 1) + 1;
            }

            if (result == null || distince < result){
                result = distince;
                if (result == 1) {
                    matrix[x][y] = result;
                    matrixFlag[x][y] = 1;
                    return result;
                }
            }
        }
        srcY = tmpY;
        // 右边
        if (x + 1 < width) {
            int distince = 0;
            if (matrixFlag[x + 1][y] == 1) {
                distince = matrix[x + 1][y];
            } else if (x + 1 != srcX){
                distince = distince(matrix, x + 1, y) + 1;
            }
            if (result == null || distince < result){
                result = distince;
                if (result == 1) {
                    matrix[x][y] = result;
                    matrixFlag[x][y] = 1;
                    return result;
                }
            }
        }
        srcX = tmpX;
        // 下边
        if (y + 1 < height) {
            int distince = 0;
            if (matrixFlag[x][y + 1] == 1) {
                distince = matrix[x][y + 1];
            } else if (y + 1 != srcY) {
                distince = distince(matrix, x, y + 1) + 1;
            }
            if (result == null || distince < result){
                result = distince;
                if (result == 1) {
                    matrix[x][y] = result;
                    matrixFlag[x][y] = 1;
                    return result;
                }
            }
        }
        srcY = tmpY;
        matrix[x][y] = result;
        matrixFlag[x][y] = 1;
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
                {0,1,0},
                {1,1,0},
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
        Solution solution = new Solution();
        solution.updateMatrix(matrix);
        for (int[] arr : matrix) {
            for(int a : arr) {
                System.out.printf("%d,", a);
            }
            System.out.println();
        }
    }
}
