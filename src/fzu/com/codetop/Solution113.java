package fzu.com.codetop;

import java.util.*;

public class Solution113 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Deque<Integer> deque = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) return;
        sum += root.val;
        deque.addLast(root.val);
        if (root.left == null && root.right == null && targetSum == sum) {
            res.add(new ArrayList<>(deque));
            deque.pollLast();
            return;
        }

        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        deque.pollLast();
    }

}
