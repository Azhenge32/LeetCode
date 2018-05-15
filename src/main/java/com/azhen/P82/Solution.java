package com.azhen.P82;

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
        ListNode tmpHead = head;
        while (head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        if (head != tmpHead && head.val == tmpHead.val) {
            head = head.next;
        }

        ListNode current = head;
        ListNode pre = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                ListNode inner = current.next;
                while (inner != null && inner.val == current.val) {
                    inner = inner.next;
                }
                pre.next = inner;
                current = inner;
            } else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        main4(args);
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        Solution solution = new Solution();
        n1 = solution.deleteDuplicates(n1);
        show(n1);
    }

    public static void main2(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
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
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Solution solution = new Solution();
        n1 = solution.deleteDuplicates(n1);
        show(n1);
    }

    public static void main4(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
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
