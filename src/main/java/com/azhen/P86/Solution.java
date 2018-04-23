package com.azhen.P86;

/**
 * @author Azhen
 * @date 2018/04/23
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        while (p1 != null && p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }

        if (p1.next == null) {
            return head;
        }

        ListNode p3 = p1.next;
        while (p3 != null) {
            ListNode p2 = p3.next;
            if (p2 != null && p2.val < x) {
                p3.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2;
            } else {
                p3 = p3.next;
            }
        }

        return dummy.next;
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Solution solution = new Solution();
        n1 = solution.partition(n1, 3);
        solution.showList(n1);
    }

    public static void main2(String[] args) {
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Solution solution = new Solution();
        n1 = solution.partition(n1, 6);
        solution.showList(n1);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Solution solution = new Solution();
        n1 = solution.partition(n1, 6);
        solution.showList(n1);
    }

    private void showList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
