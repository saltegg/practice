package fzu.com.lc.linklist;
 
//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 344 👎 0

public class PartitionList{
    public static void main(String[] args) {
	    Solution solution = new PartitionList().new Solution();
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
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;
        ListNode curNode = head, lastNode = null, posNode = null;
        while (curNode != null && curNode.val < x) {
           posNode = curNode;
           curNode = curNode.next;
        }
        while (curNode != null) {
            if (curNode.val < x) {
                if (posNode != null) {
                    ListNode tmp = curNode.next;
                    lastNode.next = tmp;
                    curNode.next = posNode.next;
                    posNode.next = curNode;
                    posNode = curNode;
                    curNode = tmp;
                } else {
                    ListNode tmp = curNode.next;
                    lastNode.next = tmp;
                    posNode = curNode;
                    posNode.next = head;
                    head = posNode;
                    curNode = tmp;
                }
            } else {
                lastNode = curNode;
                curNode = curNode.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}