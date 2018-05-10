package com.azhen.P328;

public class Solution1 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode oddEnd = null;
        ListNode evenEnd = null;
        int i = 1;
        while (head != null) {
            if (i % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenEnd = head;
                }else {
                    evenEnd.next = head;
                    evenEnd = evenEnd.next;
                    if (evenHead.next == null) {
                        evenHead.next = evenEnd;
                    }
                }

            } else {
                if (oddHead == null) {
                    oddHead = oddEnd = head;
                } else {
                    oddEnd.next = head;
                    oddEnd = oddEnd.next;
                    if (oddHead.next == null) {
                        oddHead.next = oddEnd;
                    }
                }
            }
            head = head.next;
             i ++;
        }

        if (evenEnd != null) {
            evenEnd.next = null;
        }
        if (oddEnd != null) {
            oddEnd.next = evenHead;
        }
        return (oddHead == null) ? evenHead : oddHead ;
    }

    private void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
       /* ListNode n2 = new ListNode(1);
       ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(6);
        ListNode n55 = new ListNode(5);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(8);*/
        /*n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n55;
        n55.next = n6;
        n6.next = n7;*/
        Solution1 solution = new Solution1();
        n1 = solution.oddEvenList(n1);
        solution.show(n1);
    }
}
