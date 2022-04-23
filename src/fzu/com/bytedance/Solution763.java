package fzu.com.bytedance;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public List<Integer> partitionLabels(String s) {

        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        int[] map = new int[30];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map[s.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = start +1;
            }
        }
        return res;
    }
}
