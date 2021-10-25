package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution68_1 {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> row = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int curLen = 0;
        for (String word : words) {
            int tmp = maxWidth - row.size();
            if (curLen + word.length() <= tmp) {
                curLen += word.length();
                row.add(word);
            } else {
                int blank = maxWidth - curLen;
                StringBuilder sb = new StringBuilder();
                if (row.size() > 1) {
                    int eachBlank = blank / (row.size() - 1);
                    int mod = blank % (row.size() - 1);
                    for (int i = 0; i < row.size(); i++) {
                        sb.append(row.get(i));
                        if (i == row.size() - 1) continue;
                        for (int j = 0; j < eachBlank; j++) {
                            sb.append(" ");
                        }
                        if (mod > 0) {
                            sb.append(" ");
                            mod--;
                        }
                    }
                } else {
                    sb.append(row.get(0));
                    for (int j = 0; j < blank; j++) {
                        sb.append(" ");
                    }
                }
                ans.add(sb.toString());
                curLen = word.length();
                row.clear();
                row.add(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String rowWord : row) {
            sb.append(rowWord).append(" ");
        }
        if (curLen + row.size() - 1 == maxWidth) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            for (int i = 0; i < maxWidth - row.size() - curLen; i++) {
                sb.append(" ");
            }
        }
        ans.add(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}
