package fzu.com.lc.pre200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: linxiaohui
 * @Date: 2021/11/14 10:33
 * @Description:
 */
public class Competition267 {

    public int timeRequiredToBuy(int[] tickets, int k) {

        int t = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    t++;
                }
                if (tickets[k] == 0) break;
            }
        }
        return t;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){ val = x; }
        ListNode(int x, ListNode next) { this.val = x; this.next = next; }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {

        int group = 1, cnt = 0;
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode tail;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (curNode != null) {
            cnt++;
            deque.add(curNode);
            if (cnt == group && group % 2 == 0) {
                tail = curNode.next;
                while (!deque.isEmpty()) {
                    ListNode tmp = deque.pollLast();
                    preNode.next = tmp;
                    preNode = tmp;
                }
                preNode.next = tail;
                curNode = preNode;
            }
            if (cnt == group) {
                cnt = 0;
                group++;
                preNode = curNode;
                deque.clear();
            }
            curNode = curNode.next;
        }
        if (cnt % 2 == 0) {
            while (!deque.isEmpty()) {
                ListNode tmp = deque.pollLast();
                preNode.next = tmp;
                preNode = tmp;
            }
            preNode.next = null;
        }
        return head;
    }

    public String decodeCiphertext(String encodedText, int rows) {


        int aaa;
        return null;
    }
}
