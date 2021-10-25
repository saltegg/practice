package fzu.com.lc.pre200;

public class Solution83 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dupHead = head.next, preNode = head;
        int tmp = head.val;
        while (dupHead != null) {
            if (dupHead.val == tmp) {
                preNode.next = dupHead.next;
            } else {
                preNode = dupHead;
                tmp = dupHead.val;
            }
            dupHead = dupHead.next;
        }
        return head;
    }
}
