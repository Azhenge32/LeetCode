package com.azhen.P547;

public class Solution {
    class UF {
        private int[] id;
        private int[] size; // 保存树的大小
        private int mergeCount;  // 树合并的次数

        public UF(int n) {
            mergeCount = n;
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

        int getMergeCount() {
            return mergeCount;
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
            mergeCount --;
        }

        public int getGroupCount() {
            int sum = 0;
            int group = 0;
            for (int i = 0; i < id.length; i ++) {
                group = find(i);
                if (i == group) {
                    sum ++;
                }
            }
            return sum;
        }
    }

    public int findCicleNum(int[][] M) {
        if (M == null) {
            return 0;
        }

        if (M[0] == null || M[0].length == 0) {
            return 0;
        }
        int rows = M.length;
        int cols = M[0].length;
        UF uf = new UF(cols);

        int curr;
        for (int i = 0; i < rows; i ++) {
            for (int j = i + 1; j < cols; j ++) {
                curr = M[i][j];
                if (curr == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.getGroupCount();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[][] M = new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };*/
        int[][] M = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(solution.findCicleNum(M));
    }
}
