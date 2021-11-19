package fzu.com.topic.datastructure.tree;

public class Solution230 {

    public class TreeNode {
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

    //private int ans = 0, cur = 0;

    public int kthSmallest(TreeNode root, int k) {
        /*dfs(root, k, 0);
        return ans;*/
        int leftNum = nodeNum(root.left);
        if (leftNum + 1 == k) return root.val;
        else if (k < leftNum + 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftNum - 1);
        }
    }

    private int nodeNum(TreeNode root) {
        if (root == null) return 0;
        return nodeNum(root.left) + nodeNum(root.right) + 1;
    }

    /*private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        cur++;
        if (cur == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }*/
}

