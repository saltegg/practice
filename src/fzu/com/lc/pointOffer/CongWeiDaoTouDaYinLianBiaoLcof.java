package fzu.com.lc.pointOffer;
 
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 81 👎 0

public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
	    Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
class Solution {
    /*public int[] reversePrint(ListNode head) {
        int length = getLength(head);
        int[] res = new int[length];
        traceBack(head, res, length - 1);
        return res;
    }

    private void traceBack(ListNode head, int[] res, int cur) {
        if (head == null) return;
        traceBack(head.next, res, cur - 1);
        res[cur] = head.val;
    }

    private int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}