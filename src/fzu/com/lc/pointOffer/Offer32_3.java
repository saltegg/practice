package fzu.com.lc.pointOffer;

import java.util.*;

public class Offer32_3 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        int level = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            level++;
            int len = queue.size();
            List<Integer> elem = new ArrayList<>();
            while (len > 0) {
                TreeNode tmp = null;
                if (level % 2 == 1) {
                    tmp = queue.pollFirst();
                    //elem.add(tmp.val);
                    if (tmp.left != null) queue.addLast(tmp.left);
                    if (tmp.right != null) queue.addLast(tmp.right);
                } else {
                    tmp = queue.pollLast();
                    //elem.add(tmp.val);
                    if (tmp.right != null) queue.addFirst(tmp.right);
                    if (tmp.left != null) queue.addFirst(tmp.left);
                }
                elem.add(tmp.val);
                len--;
            }
            ans.add(elem);
        }
        return ans;
    }
}
