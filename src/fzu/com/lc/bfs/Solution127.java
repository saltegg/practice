package fzu.com.lc.bfs;

import java.util.*;

public class Solution127 {

    class Node {
        int id;   // 节点编号
        String word;
        List<Integer> neighbors;
        public Node(int id, String word, List<Integer> neighbors) {
            this.id = id;
            this.word = word;
            this.neighbors = neighbors;
        }
    }

    private boolean isValid(String s, String t) {   // 判断是否只有一个字母不同
        int k = 0;
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (arrayS[i] != arrayT[i]) k++;
            if (k > 1) return false;
        }
        return k != 0;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();   // 返回的答案
        if (!wordList.contains(endWord)) return res;

        int k = 1;
        boolean isFound = false;
        boolean[] visited = new boolean[wordList.size() + 1];  // 标记是否访问
        Queue<List<Node>> queue = new LinkedList<>();   // BFS专用队列,用于存储路径
        List<Node> path = new ArrayList<>();
        Node[] nodes = new Node[wordList.size() + 1];
        Node firstNode = new Node(0, beginWord, new LinkedList<>());   // 构建邻接表首尾端点
        nodes[0] = firstNode;
        for (String word : wordList) {   // 构建整个邻接表
            if (isValid(nodes[0].word, word)) nodes[0].neighbors.add(k);
            Node node = new Node(k, word, new LinkedList<>());
            if (isValid(node.word, beginWord)) node.neighbors.add(0);
            for (int i = 0; i < wordList.size(); i++) {
                if (isValid(node.word, wordList.get(i))) node.neighbors.add(i + 1);
            }
            nodes[k++] = node;
        }

        Set<Integer> subVisited = new HashSet<>();
        path.add(nodes[0]);
        queue.offer(path);
        visited[0] = true;
        while (!queue.isEmpty()) {
            subVisited.clear();
            int queueLength = queue.size();
            while (queueLength > 0) {
                List<Node> p = queue.poll();
                queueLength--;
                Node lastNode = p.get(p.size() - 1);
                for (int nodeID : lastNode.neighbors) {
                    if (!visited[nodeID]) {
                        if (nodes[nodeID].word.equals(endWord)) {
                            isFound = true;
                            p.add(nodes[nodeID]);
                            List<String> list = new ArrayList<>();
                            for (Node n : p) {
                                list.add(n.word);
                            }
                            res.add(list);
                            p.remove(p.size() - 1);
                        }
                        p.add(nodes[nodeID]);
                        queue.add(new ArrayList<>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(nodeID);
                    }
                }
            }
            for (int r : subVisited) {
                visited[r] = true;
            }
            if (isFound) break;
        }
        return res;
    }
}
