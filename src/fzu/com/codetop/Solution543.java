package fzu.com.codetop;

public class Solution543 {

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

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;
    }
}
