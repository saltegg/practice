package fzu.com.codetop;

import fzu.com.lc.linklist.Solution19;

public class Solution83 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = head, curNode = head.next;
        int tmp = head.val;
        while (curNode != null) {
            if (curNode.val != tmp) {
                preNode.next = curNode;
                preNode = curNode;
                tmp = preNode.val;
            }
            curNode = curNode.next;
        }
        preNode.next = null;
        return head;
    }
}
