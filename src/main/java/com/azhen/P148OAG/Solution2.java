package com.azhen.P148OAG;

/**
 * @author Azhen
 * @date 2018/04/25
 */
public class Solution2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(1);
        // 把list分开两端
        ListNode preFirstHead = head;
        ListNode firstHead = head;
        ListNode secondHead = head;
        while (secondHead != null) {
            preFirstHead = firstHead;
            firstHead = firstHead.next;
            if (secondHead.next != null) {
                secondHead = secondHead.next.next;
            } else {
                break;
            }
        }
        preFirstHead.next = null;
        // 第二段排序
        secondHead = sortList(firstHead);
        // 第一段排序
        firstHead = sortList(head);
        // 把两段合并
        ListNode curr = root;
        while (firstHead != null && secondHead != null) {
            if (firstHead.val < secondHead.val) {
                curr.next = firstHead;
                firstHead = firstHead.next;
            } else {
                curr.next = secondHead;
                secondHead = secondHead.next;
            }
            curr = curr.next;
        }

        ListNode thirdHead = (firstHead == null) ? secondHead : firstHead;
        curr.next = thirdHead;
        return root.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1 = new Solution2().sortList(n1);
        show(n1);
    }

    public static void main1(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1 = new Solution2().sortList(n1);
        show(n1);
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
