package com.azhen.P82;

import com.azhen.P83.Solution_Best;

public class Solution1 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
       ListNode root = new ListNode(1);
       ListNode curr = root;
       int times = 0;
       while (head != null) {
           if ((head.next != null && head.val == head.next.val)) {
               times ++;
           } else {
               if (times == 0) {
                   curr.next = head;
                   curr = head;
               }
               times = 0;
           }

           head = head.next;
           curr.next = null;    // Add到新List之后，记得把next置null
       }
       return root.next;
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
        Solution1 solution = new Solution1();
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
        Solution1 solution = new Solution1();
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
        Solution1 solution = new Solution1();
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
        Solution1 solution = new Solution1();
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
