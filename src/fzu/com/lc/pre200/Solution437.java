package fzu.com.lc.pre200;

public class Solution437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int cnt;

    private void dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) return;
        sum += root.val;
        if (targetSum == sum) cnt++;
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        //return cnt;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        cnt = 0;
        dfs(root, targetSum, 0);
        int sum = cnt;
        int a = pathSum(root.left, targetSum);
        int b = pathSum(root.right, targetSum);
        return a + b + sum;
    }
}
