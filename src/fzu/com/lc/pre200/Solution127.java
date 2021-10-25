package fzu.com.lc.pre200;

import java.util.*;

public class Solution127 {

    static class Node {
        int id;
        String value;
        List<Integer> neighbors;
        public Node(int id, String value, List<Integer> neighbors) {
            this.id = id;
            this.value = value;
            this.neighbors = neighbors;
        }
    }

    private static boolean isValid(String s, String t) {   // 判断是否只有一个字母不同
        int k = 0;
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (arrayS[i] != arrayT[i]) k++;
            if (k > 1) return false;
        }
        return k != 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int i = 1, level = 0;
        boolean[] visited = new boolean[wordList.size() + 1];
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        nodes.add(new Node(0, beginWord, new ArrayList<>()));
        for (String word : wordList) {
            nodes.add(new Node(i, word, new ArrayList<>()));
        }
        for (Node node : nodes) {
            String word = node.value;
            for (i = 0; i < wordList.size(); i++) {
                if (isValid(word, wordList.get(i))) {
                    node.neighbors.add(i + 1);
                }
            }
        }
        queue.add(nodes.get(0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();
            while (len-- > 0) {
                Node node = queue.poll();
                if (node.value.equals(endWord)) return level;
                for (Integer id : node.neighbors) {
                    if (visited[id]) continue;
                    queue.add(nodes.get(id));
                    visited[id] = true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] t = new String[]{"hot","dot","dog","lot","log","cog"};
        ladderLength("hit", "cog", Arrays.asList(t));
    }
}
