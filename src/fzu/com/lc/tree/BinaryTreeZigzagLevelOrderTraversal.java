package fzu.com.lc.tree;
 
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 328 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
	    Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 0;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            level++;
            int dSize = deque.size();
            List<Integer> levelList = new ArrayList<>();
            while (dSize > 0) {
                if (level % 2 == 1) {
                    TreeNode node = deque.pollLast();
                    levelList.add(node.val);
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                } else {
                    TreeNode node = deque.pollFirst();
                    levelList.add(node.val);
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                }
                dSize--;
            }
            res.add(levelList);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}