package com.azhen.P19;

/**
 * 双指针方法，一个指针先走n步
 */
public class Solution_len2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);   // 因为可能删除第一个结点，加上这个头结点可以减少判断
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
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

        Solution_len2 solution = new Solution_len2();
        n1 = solution.removeNthFromEnd(n1,5 );
        solution.showList(n1);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        Solution_len2 solution = new Solution_len2();
        n1 = solution.removeNthFromEnd(n1, 1);
        solution.showList(n1);

    }

    public static void main3(String[] args) {
        ListNode n1 = new ListNode(1);

        Solution_len2 solution = new Solution_len2();
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
