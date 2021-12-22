package fzu.com.codetop;

public class Solution19 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virHead = new ListNode();
        ListNode curNode = head, preNode = virHead;
        virHead.next = head;
        int i = 0, j = 0;
        while (curNode != null) {
            i++;
            if (i - j > n) {
                preNode = preNode.next;
                j++;
            }
            curNode = curNode.next;
        }
        ListNode tmp = preNode.next;
        preNode.next = tmp.next;
        return virHead.next;

    }
}
