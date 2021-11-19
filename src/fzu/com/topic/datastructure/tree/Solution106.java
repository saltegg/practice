package fzu.com.topic.datastructure.tree;

public class Solution106 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int pl, int pr, int[] inorder, int il, int ir) {

        if (pl > pr || il > ir) return null;
        int rootValue = postorder[pr];
        int rootIndex = 0;

        for (int i = il; i <= ir; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        int lNum = rootIndex - il, rNum = ir - rootIndex;
        root.left = build(postorder, pl, pl + lNum - 1, inorder, il, rootIndex - 1);
        root.right = build(postorder, pr - rNum, pr - 1, inorder, rootIndex + 1, ir);
        return root;
    }

}
