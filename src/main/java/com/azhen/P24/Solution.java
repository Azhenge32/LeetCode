package com.azhen.P24;

import org.w3c.dom.NodeList;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        ListNode nextHead = null;
        while (head != null) {
            if (head.next != null) {
                nextHead = head.next.next;
            } else {
                curr.next = head;
                break;
            }

            curr.next = head.next;
            head.next.next = head;
            curr = curr.next.next;
            curr.next = null;

            head = nextHead;
        }
        return root.next;
    }

    public static void main(String[] args) {
        main2(args);
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution solution = new Solution();
        n1 = solution.swapPairs(n1);
        show(n1);
    }

    public static void main2(String[] args) {
        ListNode n1 = new ListNode(1);

        Solution solution = new Solution();
        n1 = solution.swapPairs(n1);
        show(n1);
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
