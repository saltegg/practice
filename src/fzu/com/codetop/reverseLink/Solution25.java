package fzu.com.codetop.reverseLink;

public class Solution25 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int len = 0;
        ListNode dupHead = head;
        while (dupHead != null) { // 看看有多长
            len++;
            dupHead = dupHead.next;
        }
        int groups = len / k;   // 总共有groups个组要翻转
        ListNode virHead = new ListNode();
        virHead.next = head;
        ListNode curNode = head, virHead2 = virHead, nextNode = null;
        while (groups-- > 0) {
            int cnt = k;
            ListNode a = curNode; // 这个现在是第一个，转完变成最后一个， 然后他的下一个要指向下一组的第一个
            while (cnt-- > 0) {  // 每组有几个要转
                ListNode tmp = curNode.next;
                curNode.next = nextNode;
                nextNode = curNode;
                curNode = tmp;
            }
            virHead2.next = nextNode;
            a.next = curNode;
            virHead2 = a;
        }
        return virHead.next;
    }
}
