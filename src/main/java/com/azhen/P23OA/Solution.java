package com.azhen.P23OA;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeLists(ListNode[] list) {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0, length = list.length; i < length; i ++) {
            ListNode head = list[i];
            while (head != null) {
                priorityQueue.add(head);
                head = head.next;
            }
        }

        ListNode root = new ListNode(1);
        ListNode curr = root;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            curr.next = node;
            curr = curr.next;
            curr.next = null;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(5);
        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);
        n31.next = n32;

        ListNode[] lists = new ListNode[]{n11, n21, n31};
        n11 = new Solution().mergeLists(lists);
        show(n11);
    }

    public static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
