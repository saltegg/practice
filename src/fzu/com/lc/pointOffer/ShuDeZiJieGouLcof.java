package fzu.com.lc.pointOffer;
 
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 178 👎 0

import java.util.ArrayDeque;
import java.util.Queue;

public class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
	    Solution solution = new ShuDeZiJieGouLcof().new Solution();
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

    private boolean check(TreeNode A, TreeNode B) {
        Queue<TreeNode> queueA = new ArrayDeque<>();
        Queue<TreeNode> queueB = new ArrayDeque<>();
        queueA.add(A);
        queueB.add(B);
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            TreeNode nodeA = queueA.poll();
            TreeNode nodeB = queueB.poll();
            if (nodeA.val == nodeB.val) {
                if (nodeA.left != null) queueA.add(nodeA.left);
                if (nodeA.right != null) queueA.add(nodeA.right);
                if (nodeB.left != null) queueB.add(nodeB.left);
                if (nodeB.right != null) queueB.add(nodeB.right);
            } else {
                return false;
            }
        }
        return queueB.isEmpty();
    }

    private boolean travel(TreeNode A, TreeNode B) {
        if (A != null) {
            if (check(A, B)) return true;
            if (travel(A.left, B)) return true;
            return travel(A.right, B);
        }
        return false;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;
        return travel(A, B);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}