package fzu.com.topic.datastructure.tree;

public class Solution114 {


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

    public void flatten(TreeNode root) {

        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmpRight = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode tmpRoot = root;
        while (tmpRoot.right != null) {
            tmpRoot = tmpRoot.right;
        }
        tmpRoot.right = tmpRight;
    }
}
