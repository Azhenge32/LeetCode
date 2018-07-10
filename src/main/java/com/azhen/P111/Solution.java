package com.azhen.P111;

import javax.swing.tree.TreeNode;

/**
 * Definition s1_for1 a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *
 *     DFS
 * }
 */
public class Solution {
    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ld = Integer.MAX_VALUE,  rd = Integer.MAX_VALUE;
        if (root.left != null) {
            ld = minDepth(root.left) + 1;
        }
        if (root.right != null) {
            rd = minDepth(root.right) + 1;
        }

        return Math.min(ld, rd);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        TreeNode node3 = new TreeNode(2);
        node2.right = node3;

        Solution solution = new Solution();
        System.out.println(solution.minDepth(node1));
    }
}
