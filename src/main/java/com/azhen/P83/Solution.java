package com.azhen.P83;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head;
        while (curr != null) {
            if ((pre != curr) && ((curr != null && curr.next != null && curr.val == curr.next.val && curr.next.next == null)
                    || (curr != null && curr.next != null && curr.next.val != curr.val))) {
                curr = curr.next;
                pre.next = curr;
                pre = curr;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        main4(args);
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;

        Solution solution = new Solution();
        n1 = solution.deleteDuplicates(n1);
        show(n1);
    }

    public static void main2(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution solution = new Solution();
        n1 = solution.deleteDuplicates(n1);
        show(n1);
    }

    public static void main3(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        Solution solution = new Solution();
        n1 = solution.deleteDuplicates(n1);
        show(n1);
    }

    public static void main4(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;

        Solution solution = new Solution();
        n1 = solution.deleteDuplicates(n1);
        show(n1);
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
