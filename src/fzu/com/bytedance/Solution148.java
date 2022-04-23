package fzu.com.bytedance;

import fzu.com.lc.linklist.Solution23;

public class Solution148 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        head = sortList(head);
        tmp = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (head != null && tmp != null) {
            if (head.val < tmp.val) {
                h.next = head;
                head = head.next;
            } else {
                h.next = tmp;
                tmp = tmp.next;
            }
            h = h.next;
        }
        h.next = head == null? tmp : head;
        return res.next;
    }
}
