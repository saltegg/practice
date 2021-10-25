package fzu.com.lc.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {  // 统计 t 串中各字符的个数
            char cur = t.charAt(i);
            if (!mapT.containsKey(cur)) {
                mapT.put(cur, 1);
            } else {
                mapT.put(cur, mapT.get(cur) + 1);
            }
        }
        String res = "";
        int r, l = 0, cnt = 0, minSize = s.length() + 1;
        for (r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            if (mapT.containsKey(cur) && mapT.get(cur) > 0) {
                mapT.put(cur, mapT.get(cur) - 1);
                cnt++;  // 当cnt达到t的长度时，说明l-r的串口包含t的所有字符
            } else if (mapT.containsKey(cur) && mapT.get(cur) <= 0) {
                mapT.put(cur, mapT.get(cur) - 1); // 负数表示l-r的窗口中对于某个字符的需求有多余（超过所需个数）
            }
            while (cnt == t.length()) {  // 表示 l-r 的窗口已经包含t中所有字符
                if (r - l + 1 < minSize) {  // 如果当前窗口小于之前的窗口，则取而代之
                    res = s.substring(l, r + 1);
                    minSize = r - l + 1;
                }
                char tmp = s.charAt(l);  // 移除窗口左边界字符
                if (mapT.containsKey(tmp) && mapT.get(tmp) == 0) {
                    mapT.put(tmp, mapT.get(tmp) + 1);
                    cnt--; // 如果该字符是 t 串中的字符, 并且 l 的右侧没有当前字符了
                } else if (mapT.containsKey(tmp) && mapT.get(tmp) < 0) {
                    mapT.put(tmp, mapT.get(tmp) + 1);
                    // 如果该字符是 t 串中的字符, 并且 l 的右侧还有当前字符了
                    // 此时 l-r 的窗口，依然包含 t 串所有字符
                }
                l++;  // 窗口左边界右移， 缩小窗口， 寻找最小匹配
                if (l >= s.length()) break;
             }
         }
        return  res;
    }

    public static void main(String[] args) {
        /*String s = "aaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));*/
    }
}
