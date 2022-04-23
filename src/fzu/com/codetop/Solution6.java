package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {


    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int k = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            list.get(k).append(s.charAt(i));
            if (k == 0 || k == numRows - 1) flag *= -1;
            k += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder c : list) res.append(c);
        return res.toString();
    }
}
