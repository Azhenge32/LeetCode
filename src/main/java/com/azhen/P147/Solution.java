package com.azhen.P147;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode next = head.next;
        ListNode curr = next;
        while (curr != null) {
           next = next.next;
           if (curr.val < first.val) {
               curr.next = first;
               first = curr;
           } else {
               ListNode tmp = first;
               ListNode preTmp = null;
               while (tmp != null && curr.val >= tmp.val) {
                   preTmp = tmp;
                   tmp = tmp.next;
               }

               if (preTmp != null) {
                   preTmp.next = curr;
                   curr.next = tmp;
               }

           }
           curr = next;
        }
        return first;
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1 = new Solution().insertionSortList(n1);
        show(n1);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1 = new Solution().insertionSortList(n1);
        show(n1);
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
