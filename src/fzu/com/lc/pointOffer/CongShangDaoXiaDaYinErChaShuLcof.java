package fzu.com.lc.pointOffer;
 
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 58 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
	    Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (null == root) return new int[]{};
        Queue<TreeNode> queue  = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            res.add(curNode.val);
            if (curNode.left != null) queue.add(curNode.left);
            if (curNode.right != null) queue.add(curNode.right);
        }
        int k = 0;
        int[] ans = new int[res.size()];
        for (int c : res) {
            ans[k++] = c;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}