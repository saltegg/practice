package fzu.com;

public class Offer54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int cur, ans;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        if (++cur == k) ans = root.val;
        dfs(root.left, k);
    }
}
