package fzu.com.lc;

public class Solution2 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int forward = 0;
        ListNode l = null;
        ListNode last = null;
        while (l1 != null && l2 != null) {
            int x =l1.val + l2. val + forward;
            if (x >= 10) {
                forward = 1;
                x = x - 10;
            } else {
                forward = 0;
            }
            ListNode newNode = new ListNode(x);
            newNode.next = null;
            if (last == null){
                l = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int x = l1.val + forward;
            if (x >= 10) {
                forward = 1;
                x = x - 10;
            } else {
                forward = 0;
            }
            ListNode newNode = new ListNode(x);
            newNode.next = null;
            last.next = newNode;
            last = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int x = l2.val + forward;
            if (x >= 10) {
                forward = 1;
                x = x - 10;
            } else {
                forward = 0;
            }
            ListNode newNode = new ListNode(x);
            newNode.next = null;
            last.next = newNode;
            last = newNode;
            l2 = l2.next;
        }
        if (forward > 0) {
            ListNode newNode = new ListNode(1);
            newNode.next = null;
            last.next = newNode;
        }
        return l;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(0);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        ListNode l = addTwoNumbers(l1, l2);


    }
}
