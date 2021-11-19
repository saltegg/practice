package fzu.com.topic.datastructure.tree;

public class Solution105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {

        if (pl == pr) return null;
        int rootValue = preorder[pl];
        int rootIndex = il;
        for (int i = il; i < ir; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        int lNum = rootIndex - il;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, pl + 1, pl + lNum + 1, inorder, il, rootIndex);
        root.right = build(preorder, pl + lNum + 1, pr, inorder, rootIndex + 1, ir);
        return root;
    }

    private TreeNode build1(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {

        if (pl > pr) return null;
        int rootValue = preorder[pl];
        int rootIndex = 0;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        int lNum = rootIndex - il;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, pl + 1, pl + lNum, inorder, il, rootIndex - 1);
        root.right = build(preorder, pl + lNum + 1, pr, inorder, rootIndex + 1, ir);
        return root;
    }
}
