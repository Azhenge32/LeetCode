package com.azhen.P234OA;

import java.util.List;
import java.util.Stack;

/**
 * @author Azhen
 * @date 2018/04/23
 */
public class Solution_Reverse {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        // TODO 能不能根据序列产生一个唯一的数
        StringBuilder builder1 = new StringBuilder();
        ListNode p1 = head;
        int i = 0;
        while (p1 != null) {
            builder1.append(p1.val);
            i ++;
            p1 = p1.next;
        }

        StringBuilder builder2 = new StringBuilder();
        i = 0;
        head = reverse(head);
        while (head != null) {
            builder2.append(head.val);
            i ++;
            head = head.next;
        }
        return builder1.toString().equals(builder2.toString());
    }

    private ListNode reverse(ListNode head) {
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

    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n22 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        // n2.next = n3;
        n2.next = n22;
        n22.next = n3;
        n3.next = n4;

        Solution_Reverse solution = new Solution_Reverse();
        System.out.println(solution.isPalindrome(n1));
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n22 = new ListNode(0);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n22;
        n22.next = n3;

        Solution_Reverse solution = new Solution_Reverse();
        System.out.println(solution.isPalindrome(n1));
    }

}
