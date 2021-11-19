package fzu.com.topic.datastructure.tree;

public class Solution98 {


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

    Integer min = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        if (isValidBST(root.left)) {
            if (root.val >= min) {
                min = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    boolean isValidBST1(TreeNode root) {
        return isValidBST2(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST2(root.left, min, root)
                && isValidBST2(root.right, root, max);
    }
}
