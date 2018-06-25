package com.demo.LinkedList;

public class SingleLinkedList {
    private static ListNode reverseNotRecursive(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    private static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = reverseRecursive(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1 = reverseRecursive(n1);
        print(n1);
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
