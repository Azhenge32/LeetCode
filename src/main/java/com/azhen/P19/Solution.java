package com.azhen.P19;

/**
 * 双指针方法，一个指针先走n步
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int len) {
        ListNode p1 = head;
        ListNode p2 = p1;
        int n = len;
        while (p2 != null && n -- > 0) {
            p2 = p2.next;
        }

        int step = 0;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            step ++;
        }

        // 各种case判断
        if (step == 0) {
            if (p2 == null) {
                head = head.next;
            } else {
                p1.next = p1.next.next;
            }
        } else {
            p1.next = p1.next.next; // 主过程
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

        Solution solution = new Solution();
        n1 = solution.removeNthFromEnd(n1,1 );
        solution.showList(n1);
    }

    public static void main2(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        Solution solution = new Solution();
        n1 = solution.removeNthFromEnd(n1, 2);
        solution.showList(n1);

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);

        Solution solution = new Solution();
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
