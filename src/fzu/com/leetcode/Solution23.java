package fzu.com.leetcode;

public class Solution23 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }

    //合并两个有序链表
    private static ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode tail = l;
        while (l1 !=null && l2 != null) {
            if (l1.val >= l2. val) {
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null? l2 : l1;
        return l.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode cur = null;
        for (ListNode res : lists) {
            cur = merge2Lists(cur, res);
        }
        return cur;
    }

    public static void main(String[] args) {
        //ListNode[] listNodes = [[1,4,5],[1,3,4],[2,6]]
        //merge2Lists()
    }

}
