package fzu.com.bytedance;

import fzu.com.lc.linklist.Solution19;

public class Solution143 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextNode = null, curNode = slow.next;
        slow.next = null;
        while (curNode != null) {
            ListNode tmpNode = curNode.next;
            curNode.next = nextNode;
            nextNode = curNode;
            curNode = tmpNode;
        }
        ListNode dupHead = head;
        while (nextNode != null) {
            ListNode tmpNode1 = nextNode.next;
            ListNode tmpNode2 = dupHead.next;
            dupHead.next = nextNode;
            nextNode.next = tmpNode2;
            nextNode = tmpNode1;
            dupHead = tmpNode2;
        }
    }
}
