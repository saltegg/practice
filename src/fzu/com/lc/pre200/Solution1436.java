package fzu.com.lc.pre200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1436 {

    public String destCity(List<List<String>> paths) {

        Map<String, Integer> map = new HashMap<>();
        for (List<String> p : paths) {
            map.put(p.get(0), 1);
        }
        for (List<String> p : paths) {
            if (map.get(p.get(1)) == null) {
                return p.get(1);
            }
        }
        return null;
    }
}
