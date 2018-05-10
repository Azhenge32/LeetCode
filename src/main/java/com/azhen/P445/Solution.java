package com.azhen.P445;

/**
 * @author Azhen
 * @date 2018/04/16
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode ll1 = reverse(l1);
        ListNode ll2 = reverse(l2);
        l1 = ll1;
        l2 = ll2;

        int more = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + more;
            more = sum /10;
            l1.val = sum % 10;
            l2.val = l1.val;

            if (l1.next == null || l2.next == null) {
                break ;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        l1 = p1.next == null ? p1 : p2;
        l2 = p1.next == null ? p2 : p1;

        if (l2.next != null){
            l1.next = l2.next;
            l1 = l1.next;
            while (l1.next != null) {
                int sum = l1.val + more;
                more = sum / 10;
                l1.val = sum % 10;
                l1 = l1.next;
            }
        }

        int len1 = length(l1);
        int len2 = length(l2);

        if (more != 0 ) {
            if (len1 != len2) {
                int sum = more + l1.val;
                l1.val = sum % 10;
                more = sum / 10;
                if (more != 0) {
                    ListNode node1 = new ListNode(more);
                    l1.next = node1;
                }
            } else {
                ListNode node1 = new ListNode(more);
                l1.next = node1;
            }
        }

        return reverse(ll1);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private int length(ListNode l) {
        int length = 0;
        while (l != null) {
            length ++;
            l = l.next;
        }
        return length;
    }

    private static void print(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static void main8(String[] args) {
        ListNode n11 = new ListNode(7);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(4);
        ListNode n14 = new ListNode(3);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;

        ListNode n201 = new ListNode(9);
        ListNode n20 = new ListNode(9);
        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
        n201.next = n20;
        n20.next = n21;
        n21.next = n22;
        n22.next = n23;

        Solution solution = new Solution();
        ListNode root = solution.addTwoNumbers(n11, n201);
        print(root);
    }

    public static void main6(String[] args) {
        ListNode n1 = new ListNode(5);

        ListNode n2 = new ListNode(5);

        Solution solution = new Solution();
        ListNode root = solution.addTwoNumbers(n1, n2);
        print(root);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n11 = new ListNode(9);
        n1.next = n11;

        ListNode n2 = new ListNode(9);

        Solution solution = new Solution();
        ListNode root = solution.addTwoNumbers(n1, n2);
        print(root);
    }
}
