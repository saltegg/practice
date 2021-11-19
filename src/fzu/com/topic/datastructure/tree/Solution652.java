package fzu.com.topic.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution652 {

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

    private List<TreeNode> res = new ArrayList<>();

    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travel(root);
        return res;
    }

    private String travel(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = travel(root.left);
        String right = travel(root.right);
        String subTree = left + "," + right + "," + root.val;
        int frq = map.getOrDefault(subTree, 0);
        if (frq == 1) {
            res.add(root);
        }
        map.put(subTree, frq + 1);
        return subTree;
    }
}
