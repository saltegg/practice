package fzu.com.lc.pointOffer;

public class Offer52 {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode A = headA, B = headB, ans = null;
        while (A != null) {
            len1++;
            A = A.next;
        }
        while (B != null) {
            len2++;
            B = B.next;
        }
        int len = Math.abs(len1 - len2);
        if (len1 >= len2) {
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        } else {
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                ans = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return ans;
    }
}
