package fzu.com.lc.pre200;

public class Solution82 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        ListNode preNode1 = virtualHead, preNode2 = head;
        int count = 1, tmp = head.val;
        head = head.next;
        while (head != null) {
            if (head.val == tmp) {
                count++;
            } else {
                if (count > 1) {
                    preNode1.next = head;
                } else {
                    preNode1 = preNode1.next;
                }
                tmp = head.val;
                count = 1;
            }
            preNode2 = preNode2.next;
            head = head.next;
        }
        if (count > 1) preNode1.next = null;
        return virtualHead.next;
    }
}
