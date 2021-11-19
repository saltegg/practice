package fzu.com.topic.datastructure.tree;

public class Solution226 {  // 翻转二叉树

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

    public TreeNode invertTree(TreeNode root) {
         //post(root);
         //return root;
        if (root == null) return null;
        TreeNode a = invertTree(root.left);
        TreeNode b = invertTree(root.right);
        root.left = b;
        root.right = a;
        return root;
    }

    private void post(TreeNode root) {
         if (root == null) return;
         post(root.left);
         post(root.right);
         TreeNode tmp = root.left;
         root.left = root.right;
         root.right = root.left;
    }

}
