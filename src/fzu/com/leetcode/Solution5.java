package fzu.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> r = new ArrayList<>();
        for(int i = 0; i < numRows; i++) r.add(new StringBuilder());
        int k = 0, flag = -1;
        for(int i = 0; i < s.length(); i++){
            r.get(k).append(s.charAt(i));
            if(k == 0 || k == numRows - 1) flag = -1 * flag;
            k += flag;
        }

        StringBuilder m = new StringBuilder();
        for(StringBuilder a : r) m.append(a);
        return m.toString();
    }
}
