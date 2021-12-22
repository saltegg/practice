package fzu.com.codetop;

public class Solution {


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

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int t) {
        if (root == null) return;
        t = t * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += t;
            return;
        }
        dfs(root.left, t);
        dfs(root.right, t);
    }

}
