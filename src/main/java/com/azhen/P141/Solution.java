package com.azhen.P141;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode stepOne = head;
        ListNode stepTwo = head;
        while (stepOne != null && stepTwo != null && stepTwo.next != null) {
            stepOne = stepOne.next;
            stepTwo = stepTwo.next.next;
            if (stepOne == stepTwo) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

    }
}
