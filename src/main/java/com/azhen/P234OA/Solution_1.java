package com.azhen.P234OA;

import java.util.HashSet;
import java.util.Set;

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

    public boolean isPalindrome(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            int val = head.val;
            if (set.contains(val)) {
                set.remove(val);
            } else {
                set.add(val);
            }
            head = head.next;
        }
        return set.size() <= 1;
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

        Solution_1 solution = new Solution_1();
        System.out.println(solution.isPalindrome(n1));
    }
}
