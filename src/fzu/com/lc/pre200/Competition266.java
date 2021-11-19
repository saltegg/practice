package fzu.com.lc.pre200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: linxiaohui
 * @Date: 2021/11/07 10:15
 * @Description:
 */
public class Competition266 {

    public static int countVowelSubstrings(String word) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        String sub;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (j + 1 - i >= 5) {
                    sub = word.substring(i, j + 1);
                    if (check(sub, set)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean check(String subString, Set<Character> set) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < subString.length(); i++) {
            if (!set.contains(subString.charAt(i))) return false;
            map.put(subString.charAt(i), map.getOrDefault(subString.charAt(i), 0) + 1);
        }
        return map.size() == 5;
    }


    public long countVowels(String word) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        long ans = 0;
        int[][] dp = new int[word.length()][word.length()];
        for (int i = 0; i < word.length(); i++) {
            dp[i][i] = set.contains(word.charAt(i))? 1 : 0;
            ans += dp[i][i];
            for (int j = i - 1; j >= 0; j--) {
                int a = set.contains(word.charAt(j))? 1 : 0;
                dp[j][i] = dp[j + 1][i] + a;
                ans += dp[j][i];
            }
        }
        return ans;
    }

    /*private boolean iS(char c) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set.contains(c);
    }*/

    public static void main(String[] args) {
        //countVowelSubstrings("cuaieuouac");
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        check("uaieuouac",set);
    }
}
