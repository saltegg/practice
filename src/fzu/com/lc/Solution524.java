package fzu.com.lc;

import java.util.Arrays;
import java.util.List;

public class Solution524 {

    public static String findLongestWord(String s, List<String> d) {
        int max = 0;   // 记录最大长度
        String res = "";
        for (String e : d) {
            int k = 0;
            char[] cur = e.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == cur[k]) k++;
                if (k == cur.length) {
                    if (k > max || (k == max && res.compareTo(String.valueOf(cur)) > 0)) {
                        res = String.valueOf(cur);
                        max = k;
                    }
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*String[] a = {"ale","apple","monkey", "appte", "plea"};
        List<String> d = Arrays.asList(a);
        findLongestWord("", d);*/

        //String[] t = (String[]) d.toArray();
        /*Arrays.sort(t, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });*/
        String s = "wordgoodgoodgoodbestword";
        String[] ss = {"word","good","best","good"};
        String res = findLongestWord(s, Arrays.asList(ss));
        System.out.println(res);
        /*System.out.println("");*/
    }
}
