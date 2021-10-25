package fzu.com.lc.pointOffer;

public class Offer25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            ListNode tmp = null;
            if (l1.val <= l2.val) {
                tmp = l1;
                l1 = l1.next;
            } else {
                tmp = l2;
                l2 = l2.next;
            }
            cur.next = tmp;
            cur = cur.next;
        }
        cur.next = l1 == null? l2 : l1;
        return head.next;
    }
}
