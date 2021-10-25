package fzu.com.lc.slidewindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution576 {

    public static boolean checkInclusion(String s1, String s2) {
        int i, j = 0, cnt = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(s2.charAt(i))) {
                map.put(c, map.get(c) - 1);
                cnt--;
                while (j < i && map.get(c) < 0) {
                    char d = s2.charAt(j);
                    if (map.containsKey(d)) {
                        map.put(d, map.get(d) + 1);
                        cnt++;
                    }
                    j++;
                }
                if (cnt == 0) return true;
            } else {
                while (j < i) {
                    char d = s2.charAt(j);
                    if (map.containsKey(d)) {
                        map.put(d, map.get(d) + 1);
                        cnt++;
                    }
                    j++;
                }
            }
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] needs = new int[26];
        int[] res = new int[26];
        int len1 =s1.length();
        int len2 =s2.length();
        for (int i = 0; i < len1; i++) {
            needs[s1.charAt(i) - 'a']++;
            res[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2 - len1; i++) {
            if (Arrays.equals(res, needs))
                return true;
            res[s2.charAt(i + len1) - 'a']++;
            res[s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(res, needs);
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }
}
