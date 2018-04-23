package com.azhen.P19;

/**
 * 双指针方法，一个指针先走n步
 */
public class Solution_len {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        int len = 0;
        while (p1 != null) {
            len ++;
            p1 = p1.next;
        }

        int target = len - n;

        if (target == 0) {
            head = head.next;
        } else {
            ListNode p2 = head;
            while (target > 1) {
                target --;
                p2 = p2.next;
            }
            p2.next = p2.next.next;
        }

        return head;
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution_len solution = new Solution_len();
        n1 = solution.removeNthFromEnd(n1,5 );
        solution.showList(n1);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        Solution_len solution = new Solution_len();
        n1 = solution.removeNthFromEnd(n1, 1);
        solution.showList(n1);

    }

    public static void main3(String[] args) {
        ListNode n1 = new ListNode(1);

        Solution_len solution = new Solution_len();
        n1 = solution.removeNthFromEnd(n1,1 );
        solution.showList(n1);

    }

    private void showList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
