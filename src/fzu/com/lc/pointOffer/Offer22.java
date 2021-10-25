package fzu.com.lc.pointOffer;

public class Offer22 {

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public ListNode getKthFromEnd(ListNode head, int k) {

         if (head == null) return null;
         ListNode tail = head;
         int i = 1, j = 1;
         while (head != null) {
             if (j - i > k) {
                 tail = tail.next;
                 i++;
             }
             head = head.next;
             j++;
         }
         return tail;
    }
}
