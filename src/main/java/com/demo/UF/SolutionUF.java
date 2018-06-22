package com.demo.UF;

/**
 * @author Azhen
 * @date 2018/03/12
 */
public class SolutionUF {
    class UF {
        private int[] id;
        private int[] size; // 保存树的大小
        private int count;  // 组的数量

        public UF(int n) {
            count = n;
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

        int getCount() {
            return count;
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
            count --;
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

        UF uf = new UF(rows * cols + 1);

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    uf.union(i * cols + j, rows * cols);
                } else if(board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        uf.union(i * cols + j, (i - 1) * cols);
                    }
                    if (board[i + 1][j] == 'O') {
                        uf.union(i * cols + j, (i + 1) * cols);
                    }
                    if (board[i][j - 1] == 'O') {
                        uf.union(i * cols + j, i * cols + j - 1);
                    }
                    if (board[i][j + 1] == 'O') {
                        uf.union(i * cols + j, i * cols + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (!uf.connected(i * cols + j, rows * cols)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionUF solution = new SolutionUF();
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
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'X'},
                {'X', 'O', 'X'}
        };
        /*char[][] board =
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
                };*/
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
