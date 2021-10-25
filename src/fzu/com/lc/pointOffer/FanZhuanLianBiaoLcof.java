package fzu.com.lc.pointOffer;
 
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 164 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
	    Solution solution = new FanZhuanLianBiaoLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;
        ListNode tail = head;
        Deque<Integer> deque = new ArrayDeque<>();
        while (tail != null) {
            deque.addLast(tail.val);
            tail = tail.next;
        }
        tail = head;
        while (!deque.isEmpty()) {
            tail.val = deque.pollLast();
            tail = tail.next;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}