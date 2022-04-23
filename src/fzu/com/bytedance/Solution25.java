package fzu.com.bytedance;

import fzu.com.lc.linklist.Solution19;

import java.util.List;

public class Solution25 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int listLen = 0;
        ListNode dupHead = head;
        while (dupHead != null) {
            listLen++;
            dupHead = dupHead.next;
        }
        int group = listLen / k;
        ListNode a = new ListNode();
        ListNode virHead = a;
        a.next = head;
        ListNode curNode = head, nextNode = null;
        while (group-- > 0) {
            int t = k;
            while (t-- > 0) {
                ListNode tmpNode = curNode.next;
                curNode.next = nextNode;
                nextNode = curNode;
                curNode = tmpNode;
            }
            ListNode b = a.next;
            a.next = nextNode;
            b.next = curNode;
            a =b;
        }
        return virHead.next;
    }
}
