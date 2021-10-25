package fzu.com.lc.pre200;

public class Solution725 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {

        int len = 0;
        ListNode newHead = head;
        ListNode[] ans = new ListNode[k];
        while (newHead != null) {
            len++;
            newHead = newHead.next;
        }
        int dvd = len / k;
        int mod = len % k;
        if (len > 0) {
            newHead = head;
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                int loopTime = dvd;
                if (mod > 0) {
                    loopTime++;
                    mod--;
                }
                if (loopTime == 0) continue;
                while (loopTime > 1) {
                    tail = tail.next;
                    loopTime--;
                }
                ans[i] = newHead;
                newHead = tail.next;
                tail.next = null;
                tail = newHead;
            }
        }
        return ans;
    }
}
