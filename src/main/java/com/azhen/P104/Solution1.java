package com.azhen.P104;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Azhen
 * @date 2018/03/12
 */
public class Solution1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class NodeDepth {
        TreeNode node;
        int depth;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NodeDepth> queue = new LinkedBlockingQueue<>();
        NodeDepth nd = new NodeDepth();
        nd.node = root;
        nd.depth = 1;
        queue.add(nd);
        Integer maxDepth= 1;
        while (!queue.isEmpty()) {
            NodeDepth curr = queue.poll();
            TreeNode node = curr.node;
            if (node.left == null && node.right == null) {
                maxDepth = Math.max(maxDepth, curr.depth);
            }
            if (node.left != null) {
                NodeDepth ndl = new NodeDepth();
                ndl.node = node.left;
                ndl.depth = curr.depth + 1;
                queue.add(ndl);
            }
            if (node.right != null) {
                NodeDepth ndl = new NodeDepth();
                ndl.node = node.right;
                ndl.depth = curr.depth + 1;
                queue.add(ndl);
            }
        }
        return maxDepth;
    }
}
