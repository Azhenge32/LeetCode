package com.azhen.P61;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = len(head);
        k %= len;
        if (k == 0) {
            return head;
        }

        ListNode p2 = head;
        ListNode p1 = head;
        while (k > 0) {
            p2 = p2.next;
            if (p2 == null) {
                p2 = head;
            }
            k --;
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p2.next = head;

        head = p1.next;
        p1.next = null;
        return head;
    }

    private int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution solution = new Solution();
        ListNode head = solution.rotateRight(n1, 6);
        solution.show(head);
    }

    private void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
