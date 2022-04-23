package fzu.com.bytedance;

import fzu.com.lc.tree.Solution257;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int flag = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelSet = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tmpNode;
                if (flag == 0) {
                    tmpNode = deque.pollFirst();
                    levelSet.add(tmpNode.val);
                    if (tmpNode.left != null) {
                        deque.addLast(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        deque.addLast(tmpNode.right);
                    }
                } else {
                    tmpNode = deque.pollLast();
                    levelSet.add(tmpNode.val);
                    if (tmpNode.right != null) {
                        deque.addFirst(tmpNode.right);
                    }
                    if (tmpNode.left != null) {
                        deque.addFirst(tmpNode.left);
                    }
                }
            }
            flag = flag == 0? 1 : 0;
            res.add(levelSet);
        }
        return res;
    }
}
