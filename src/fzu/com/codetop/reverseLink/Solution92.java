package fzu.com.codetop.reverseLink;

public class Solution92 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int x, ListNode next) { this.val = x; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode virHead = new ListNode();
        virHead.next = head;
        ListNode preNode = virHead, curNode = virHead;
        int i = 0;
        while (i < left) {
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        ListNode nextNode = null, tailNode = curNode;
        while (i <= right) {
            ListNode tmp = curNode.next;
            curNode.next = nextNode;
            nextNode = curNode;
            curNode = tmp;
            i++;
        }
        preNode.next = nextNode;
        tailNode.next = curNode;
        return virHead.next;
    }
}
