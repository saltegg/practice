package fzu.com.lc.pre200;

import java.util.*;

public class Competition264 {

    public static int countValidWords(String sentence) {

        int cnt = 0;
        String[] tokens = sentence.split(" ");
        for (String token : tokens) {
            if (!token.equals("") && token.length() > 0 &&check(token)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean check(String token) {
        int t = 0;
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (c >= '0' && c <= '9') {
                return false;
            } else if (c == '-') {
                if (t == 1) return false;
                if (i == 0 || i == token.length() - 1) return false;
                if (token.charAt(i - 1) >= 'a' && token.charAt(i - 1) <= 'z' &&
                        token.charAt(i + 1) >= 'a' && token.charAt(i + 1) <= 'z') {
                    t++;
                } else {
                    return false;
                }
            } else if (c == '!' || c == '.' || c == ',') {
                if (i != token.length() - 1) return false;
            }
        }
        return true;
    }


    public static int nextBeautifulNumber(int n) {
        int[] cntArray = new int[10];
        while (true) {
            n++;
            Arrays.fill(cntArray, 0);
            boolean flag = false;
            int temp = n;
            while (temp > 0) {
                int t = temp % 10;
                temp /= 10;
                cntArray[t]++;
            }
            if (cntArray[0] > 0) continue;
            for (int i = 1; i < cntArray.length; i++) {
                if (cntArray[i] == 0) continue;
                if (cntArray[i] != i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return n;
        }
    }

    public int countHighestScoreNodes(int[] parents) {
        long maxScore = 0;
        int res = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] count = new int[parents.length];
        for (int i = 1; i < parents.length; i++) {
            if (map.containsKey(parents[i])) {
                map.get(parents[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(parents[i], list);
            }
        }
        dfs(0, map, count);
        List<Integer> sun = null;
        for (int i = 0; i < parents.length; i++) {
            long curScore = 1;
            if (parents[i] == -1) {
                sun = map.get(i);
            } else {
                sun = map.get(i);
                curScore = count[0] - count[i];
            }
            if (sun != null) {
                for (Integer id : sun) {
                    curScore *= count[id];
                }
            }
            if (curScore > maxScore) {
                maxScore = curScore;
                res = 1;
            } else if (curScore == maxScore) {
                res++;
            }
        }
        return res;
    }

    private void dfs(int index,  Map<Integer, List<Integer>> map, int[] count) {
        List<Integer> sun = map.getOrDefault(index, new ArrayList<>());
        if (sun.size() == 0) {
            count[index] = 1;
            return;
        }
        for (Integer id : sun) {
            dfs(id, map, count);
            count[index] += count[id];
        }
        count[index]++;
    }



    public static void main(String[] args) {

    }
}
