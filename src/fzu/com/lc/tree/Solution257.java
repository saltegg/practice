package fzu.com.lc.tree;

import java.util.*;

public class Solution257 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root, List<String> res, StringBuilder stack) {
        stack.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(stack.toString());
            return;
        }
        if (root.left != null) {
            dfs(root.left, res, new StringBuilder(stack).append("->"));
        }
        if (root.right != null) {
            dfs(root.right, res, new StringBuilder(stack).append("->"));
        }
     }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        Deque<Character> stack = new ArrayDeque<Character>();
        stack.add('1');
        stack.add('-');
        stack.add('>');
        stack.add('2');
    }
}
