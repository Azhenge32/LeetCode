package com.azhen.P86;

/**
 * @author Azhen
 * @date 2018/04/23
 */
public class Solution_1 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        ListNode smaller = smallerHead, bigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                /**
                 * smaller = smaller.next；
                 * smaller.next = head;
                 */
                smaller = smaller.next = head;
            } else {
                bigger = bigger.next = head;
            }
            head = head.next;
        }
        // no need for extra check because of fake heads
        smaller.next = biggerHead.next; // join bigger after smaller
        bigger.next = null; // cut off anything after bigger
        return smallerHead.next;
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

        Solution_1 solution = new Solution_1();
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

        Solution_1 solution = new Solution_1();
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

        Solution_1 solution = new Solution_1();
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
