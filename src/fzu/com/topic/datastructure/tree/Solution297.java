package fzu.com.topic.datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {


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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(vals));
        return travel(q);
    }

    private TreeNode travel(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        String val = queue.poll();
        if (val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = travel(queue);
        root.right = travel(queue);
        return root;
    }
}
