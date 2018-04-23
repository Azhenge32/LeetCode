package com.azhen.P234OA;

/**
 * @author Azhen
 * @date 2018/04/23
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode pLen = head;
        while (pLen != null) {
            len ++;
            pLen = pLen.next;
        }

        for (int i = 0; i < len / 2; i ++) {
            int lVal = head.val;
            int rVal = val(head, len - 2 * i - 1);
            if (lVal != rVal) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    private int val(ListNode head, int n) {
        for (int i = 0; i < n; i ++) {
            head = head.next;
        }
        return head.val;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n22 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n22;
        n22.next = n3;
        n3.next = n4;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(n1));
    }
}
