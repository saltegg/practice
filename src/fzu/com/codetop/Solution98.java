package fzu.com.codetop;

public class Solution98 {

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

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean dfs(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return dfs(root.left, root.val, min) && dfs(root.right, max, root.val);
    }
}
