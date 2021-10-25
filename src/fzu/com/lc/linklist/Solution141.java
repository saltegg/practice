package fzu.com.lc.linklist;

public class Solution141 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    /*
        public boolean hasCycle(ListNode head) {
        while (head != null) {
            if(head.val == Integer.MAX_VALUE) {
                return true;
            }
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }
     */

    /*public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }*/

    public static void main(String[] args) {

    }

}
