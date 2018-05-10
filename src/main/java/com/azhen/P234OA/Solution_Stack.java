package com.azhen.P234OA;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Azhen
 * @date 2018/04/23
 */
public class Solution_Stack {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p1 = head;
        int len = 0;
        while (p1 != null) {
            len ++;
            p1 = p1.next;
        }

        int i = 0;
        while (head != null) {
            if (len % 2 == 1 && i == len / 2) {

            } else if (i < len / 2) {
                stack.push(head.val);
            } else if (i >= len / 2) {
                int val = stack.pop();
                if (val != head.val) {
                    return false;
                }
            }
            head = head.next;
            i ++;
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
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

        Solution_Stack solution = new Solution_Stack();
        System.out.println(solution.isPalindrome(n1));
    }
}
