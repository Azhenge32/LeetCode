package com.azhen.P237;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        while (node != null) {
            if (node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null) {
                    node.next = null;
                }
            }

            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Solution solution = new Solution();
        solution.deleteNode(n3);
        show(n1);
    }

    public static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
