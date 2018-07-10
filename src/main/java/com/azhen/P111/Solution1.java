package com.azhen.P111;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NodeDepth> queue = new LinkedBlockingQueue<>();
        NodeDepth nd = new NodeDepth();
        nd.node = root;
        nd.depth = 1;
        queue.add(nd);
        while (!queue.isEmpty()) {
            NodeDepth curr = queue.poll();
            TreeNode node = curr.node;
            if (node.left == null && node.right == null) {
                return curr.depth;
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
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node2.left = node3;
        node1.right = node4;
        node4.right = node5;
        Solution1 solution = new Solution1();
        System.out.println(solution.minDepth(node1));
    }
}
