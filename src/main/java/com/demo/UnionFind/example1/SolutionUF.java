package com.demo.UnionFind.example1;

/**
 * @author Azhen
 * @date 2018/03/12
 */
public class SolutionUF {
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

        void connect(int p, int q) {
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
}
