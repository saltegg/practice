package fzu.com.topic.datastructure.tree;

public class Solution654 {

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l , int r) {
        if(r < l) return null;
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = dfs(nums, l, idx - 1);
        root.right = dfs(nums, idx + 1, r);
        return root;
    }
}
