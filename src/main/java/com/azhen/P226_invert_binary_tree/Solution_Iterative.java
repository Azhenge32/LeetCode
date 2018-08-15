package com.azhen.P226_invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Iterative {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            TreeNode left = top.left;
            TreeNode right = top.right;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }

            top.left = right;
            top.right = left;
        }
        return root;
    }
}
