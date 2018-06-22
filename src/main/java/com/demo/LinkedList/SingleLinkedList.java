package com.demo.LinkedList;

import com.azhen.P234OA.Solution_Reverse;

public class SingleLinkedList {
    private static ListNode reverse(ListNode head) {
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
}
