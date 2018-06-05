package com.azhen.P142OAG;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        int cycleSize = cycleSize(head);
        if (cycleSize == 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (cycleSize -- > 0) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public int cycleSize(ListNode head) {
        ListNode stepOne = head;
        ListNode stepTwo = head;
        int cycleSize = 0;
        while (stepOne != null && stepTwo != null && stepTwo.next != null) {
            stepOne = stepOne.next;
            stepTwo = stepTwo.next.next;
            if (stepOne == stepTwo) {
                stepTwo = stepOne.next;
                cycleSize = 1;
                while (stepTwo != stepOne) {
                    stepTwo = stepTwo.next;
                    cycleSize ++;
                }
                break;
            }
        }
        return cycleSize;
    }


/*    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1 = new Solution().detectCycle(n1);
        System.out.println(n1.val);
    }*/

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        n1 = new Solution().detectCycle(n1);
        System.out.println(n1.val);
    }
}
