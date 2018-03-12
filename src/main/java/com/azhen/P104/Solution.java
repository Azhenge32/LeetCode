package com.azhen.P104;

import javax.swing.tree.TreeNode;

/**
 * @author Azhen
 * @date 2018/03/12
 */
public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ld = Integer.MAX_VALUE,  rd = Integer.MAX_VALUE;
        if (root.left != null) {
            ld = maxDepth(root.left) + 1;
        }
        if (root.right != null) {
            rd = maxDepth(root.right) + 1;
        }

        return Math.max(ld, rd);
    }
}
