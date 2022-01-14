package fzu.com.codetop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution662 {

    public static class TreeNode {
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

    public int widthOfBinaryTree(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();
        deque.addLast(root);
        index.addLast(1);
        int ans = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = deque.pollFirst();
                int n = index.pollFirst();
                if (tmp.left != null) {
                    deque.addLast(tmp.left);
                    index.addLast(n * 2);
                }
                if (tmp.right != null) {
                    deque.addLast(tmp.right);
                    index.addLast(n * 2 + 1);
                }
            }
            if (index.size() < 2) continue;
            ans = Math.max(ans, index.getLast() - index.getFirst() +1);
        }
        return ans;
    }
}
