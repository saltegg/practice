package fzu.com.solution;

import fzu.com.lc.linklist.Solution19;

public class Solution02 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(), tail = head;
        int addition = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + addition;
            if (val >= 10) {
                addition = 1;
            } else {
                addition = 0;
            }
            val %= 10;
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode tmp = l1 == null? l2 : l1;
        while (tmp != null) {
            int val = tmp.val + addition;
            if (val >= 10) {
                addition = 1;
            } else {
                addition = 0;
            }
            val %= 10;
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = newNode;
            tmp = tmp.next;
        }
        if (addition > 0) {
            tail.next = new ListNode(addition);
        }
        return head.next;
    }
}
