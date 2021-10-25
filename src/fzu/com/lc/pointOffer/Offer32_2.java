package fzu.com.lc.pointOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Offer32_2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> elem = new ArrayList<>();
            while (len > 0) {
                TreeNode tmp = queue.poll();
                elem.add(tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right !=null) queue.add(tmp.right);
                len--;
            }
            ans.add(elem);
        }
        return ans;
    }
}
