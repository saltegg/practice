package fzu.com.codetop;

import fzu.com.lc.linklist.Solution19;

public class Solution61 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode dupHead = head;
        while (dupHead != null) {
            len++;
            dupHead = dupHead.next;
        }
        int t = k % len;
        if (t == 0) return head;
        ListNode preNode = null, curNode = head;
        while (curNode != null) {
            if (len == t) break;
            preNode = curNode;
            curNode = curNode.next;
            len--;
        }
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = head;
        head = preNode.next;
        preNode.next = null;
        return head;
    }
}
