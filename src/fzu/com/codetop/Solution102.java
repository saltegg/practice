package fzu.com.codetop;

import fzu.com.lc.tree.Solution257;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.right = right;
            this.left = left;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            dfs(root, res, 1);
        }
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            dfs(root.left, res, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, res, level + 1);
        }
    }
}
