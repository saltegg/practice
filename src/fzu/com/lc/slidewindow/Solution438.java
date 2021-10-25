package fzu.com.lc.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) { // 576加强版

        List<Integer> res = new ArrayList<>();
        if (s.equals("") || p.equals("")) return res;
        int pos = 0, len1 = s.length(), len2 = p.length();
        int[] needs = new int[26];
        int[] match = new int[26];
        for (int i = 0; i < len2; i++) {
            needs[p.charAt(i) - 'a']++;
            match[s.charAt(i) - 'a']++;
        }
        for (pos = 0; pos < len1 - len2; pos++) {
            if (Arrays.equals(needs, match)) res.add(pos);
            match[s.charAt(pos + len2) - 'a']++;
            match[s.charAt(pos) - 'a']--;
        }
        if (Arrays.equals(needs, match)) res.add(pos);
        return res;
    }
}
