package fzu.com.codetop.reverseLink;

import fzu.com.codetop.reverseLink.Solution25;

public class Solution143 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void reorderList(ListNode head) {
        int len = 0;
        ListNode dupHead = head;
        while (dupHead != null) {  // 计算链表的长度
            len++;
            dupHead = dupHead.next;
        }
        if (len < 3) return;
        if (len % 2 == 0) {
            len = len / 2 + 1;
        } else {
            len = len / 2 + 2;
        }
        int i = 1;
        ListNode preNode = null;
        dupHead = head;
        while (i < len) {
            i++;
            preNode = dupHead;
            dupHead = dupHead.next;
        }
        preNode.next = null;
        ListNode nextNode = null;
        while (dupHead != null) {
            ListNode tmp = dupHead.next;
            dupHead.next = nextNode;
            nextNode = dupHead;
            dupHead = tmp;
        }
        dupHead = head;
        while (dupHead != null && nextNode != null) {
            ListNode tmp1 = nextNode;
            nextNode = nextNode.next;
            ListNode tmp2 = dupHead.next;
            dupHead.next = tmp1;
            tmp1.next = tmp2;
            dupHead = tmp2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        reorderList(l1);
    }
}
