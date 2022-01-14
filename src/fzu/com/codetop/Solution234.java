package fzu.com.codetop;

import fzu.com.lc.linklist.Solution19;

public class Solution234 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        ListNode c = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = c;
            c = slow;
            slow = tmp;
        }
        while (c != null && head != null) {
            if (c.val != head.val) {
                return false;
            }
            c = c.next;
            head = head.next;
        }
        return true;
    }
}
