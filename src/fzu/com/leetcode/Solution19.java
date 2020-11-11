package fzu.com.leetcode;

public class Solution19 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int i = -1;
        ListNode preNode = new ListNode();
        ListNode nthFromEndNode = head;
        ListNode curNode = head;
        while (curNode != null) {
            i++;
            if(i == n) {
                preNode = nthFromEndNode;
                nthFromEndNode = nthFromEndNode.next;
                i--;
            }
            curNode = curNode.next;
        }
        if(nthFromEndNode == head) head = nthFromEndNode.next;
        else preNode.next = nthFromEndNode.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(1);
        removeNthFromEnd(head, 1);
    }
}
