package fzu.com.codetop;

public class Solution21 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode virHead = new ListNode();
        ListNode preNode = virHead;
        while (list1 != null && list2 !=null) {
            if (list1.val <= list2.val) {
                preNode.next = list1;
                list1 = list1.next;
            } else {
                preNode.next = list2;
                list2 = list2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = list1 == null? list2 : list1;
        return virHead.next;
    }
}
