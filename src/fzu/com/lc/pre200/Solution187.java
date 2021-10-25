package fzu.com.lc.pre200;

import java.util.*;

public class Solution187 {

    public static List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub) && map.get(sub) == 1) {
                ans.add(sub);
                map.put(sub, 2);
            } else if (!map.containsKey(sub)){
                map.put(sub, 1);
            }
        }
        return ans;
    }

}
