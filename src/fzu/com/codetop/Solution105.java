package fzu.com.codetop;

public class Solution105 {


    public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return dd(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dd(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {

        if (e2 < s2) return null;

        int rootVal = preorder[s1], idx = s2;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = dd(preorder, s1 + 1, s1 + idx - s2, inorder, s2, idx - 1);
        root.right = dd(preorder, s1 + idx - s2 + 1, e1, inorder, idx + 1, e2);
        return root;
    }
}
