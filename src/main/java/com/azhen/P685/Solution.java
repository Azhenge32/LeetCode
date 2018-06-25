package com.azhen.P685;

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

        boolean isConnected(int p, int q) {
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

        public boolean isGroup(int i) {
            return i == find(i);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges[0] == null) {
            return null;
        }

        UF uf = new UF(edges.length + 1);
        int[] curr = null;
        for (int i = 0; i < edges.length; i ++) {
            curr = edges[i];
            int p1 = curr[0];
            int p2 = curr[1];
            if (!uf.isConnected(p1, p2)) {
                uf.union(p1, p2);
            } else {
                return curr;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        /*int[][] edges = new int[][] {
                {1,2},
                {1,3},
                {2,3}
        };*/
        /*int[][] edges = new int[][] {
                {2,1},
                {3,1},
                {4,2},
                {1,4}
        };*/
        int[][] edges = new int[][] {
                {2,1},
                {3,1},
                {4,2},
                {1,4}
        };

        Solution solution = new Solution();
        int[] result = solution.findRedundantConnection(edges);
        for (int val : result) {
            System.out.println(val);
        }
    }
}
