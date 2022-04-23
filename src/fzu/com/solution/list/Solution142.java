package fzu.com.solution.list;

import fzu.com.lc.linklist.Solution19;

public class Solution142 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }

    public ListNode detectCycle(ListNode head) {

        /**
         * 环中元素 b， 环外元素a
         * slow走s, fast走2s ===> fast = s + nb ,意思就是先走跟slow一样的路程，然后再绕几圈，位置还是那个位置。 所以s = nb
         * 又因为 a + nb位置是入口地址
         * 所以让fast以一次走一步的速度走到入口处，此时走了a步，slow也走了a步变成 a + nb 就到了入口地址了。
         */

        ListNode fast = head, slow = head;
        do {
            if (fast == null || slow == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
