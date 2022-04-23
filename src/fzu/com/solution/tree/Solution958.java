package fzu.com.solution.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution958 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                for (TreeNode node : queue) {
                    if (node != null) return false;
                }
                return true;
            }
            queue.add(tmp.left);
            queue.add(tmp.right);
        }
        return true;
    }
}
