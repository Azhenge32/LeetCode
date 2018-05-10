package com.azhen.P328;

public class SolutionBest {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
        SolutionBest solution = new SolutionBest();
        n1 = solution.oddEvenList(n1);
        solution.show(n1);
    }
}
