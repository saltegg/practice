package fzu.com.lc.pointOffer;
 
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 129 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
	    Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {

    private void travel(TreeNode root, int sum, int curSum,
                        List<List<Integer>> res, Deque<Integer> stack) {
        if (root != null) {
            curSum += root.val;
            stack.add(root.val);
            if (root.left == null && root.right == null) {
                if (curSum == sum) {
                    List<Integer> list = new ArrayList<>(stack);
                    res.add(list);
                }
                stack.pollLast();
                return;
            }
            travel(root.left, sum, curSum, res, stack);
            travel(root.right, sum, curSum, res, stack);
            stack.pollLast();
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Integer> stack = new ArrayDeque<>();
        travel(root, sum, 0, res, stack);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}