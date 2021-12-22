package fzu.com.codetop;

import fzu.com.codetop.reverseLink.Solution143;

public class Solution82 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode virHead = new ListNode();
        virHead.next = head;
        int dupNum = 1;
        ListNode preNode = virHead, lastNode = head, curNode = head.next;
        while (curNode != null) {
            if (curNode.val == lastNode.val) {
                dupNum++;
            } else {
                if (dupNum > 1) {
                    preNode.next = curNode;
                    dupNum = 1;
                } else {
                    preNode = preNode.next;
                }
            }
            lastNode = lastNode.next;
            curNode = curNode.next;
        }
        if (dupNum > 1) preNode.next = null;
        return virHead.next;
    }
}
