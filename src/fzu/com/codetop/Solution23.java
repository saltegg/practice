package fzu.com.codetop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {


    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode virHead = new ListNode();
        ListNode curNode = virHead;

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            curNode.next = tmp;
            curNode = curNode.next;
            if (tmp.next != null) {
                pq.add(tmp);
            }
        }
        return virHead.next;
    }

}
