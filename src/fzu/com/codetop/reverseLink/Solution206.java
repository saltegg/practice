package fzu.com.codetop.reverseLink;

public class Solution206 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }

    public ListNode reverseList(ListNode head) {

        ListNode tailNode = null, curNode = head;
        while (curNode != null) {
            ListNode tmp = curNode.next;
            curNode.next = tailNode;
            tailNode = curNode;
            curNode = tmp;
        }

        return tailNode;
    }
}
