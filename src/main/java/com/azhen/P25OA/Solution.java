package com.azhen.P25OA;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);

        int step;
        ListNode begin = head;
        ListNode curr = root;
        ListNode end = null;
        ListNode endNext = null;
        curr.next = head;
        while (begin != null) {
            step = k - 1;
            end = head;
            while (step > 0 && end != null) {
                end = end.next;
                step --;
            }

            if (end == null) {
                break;
            } else {
                endNext = end.next;
            }

            ListNode head2 = head;
            ListNode end2 = end;
            ListNode tmp = null;
            while (head2 != end2) {
                tmp = head2.next;
                head2.next = end2.next;
                end2.next = head2;
                head2 = tmp;
            }

            curr.next = end;
            curr = head;
            head = endNext;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1 = new Solution().reverseKGroup(n1, 2);
        show(n1);
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1 = new Solution().reverseKGroup(n1, 1);
        show(n1);
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
