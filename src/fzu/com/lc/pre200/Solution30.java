package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {

    public List<Integer> findSubstring(String s, String[] words) {

        int oneWord = words[0].length(), wordsLen = words.length;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < oneWord; i++) {
            int l = i, r = i, cnt = 0;
            Map<String, Integer> mapTmp = new HashMap<>();
            while (r + oneWord <= s.length()) {
                String subRWord = s.substring(r, r + oneWord);
                mapTmp.put(subRWord, mapTmp.getOrDefault(subRWord, 0) + 1);
                cnt++;
                r += oneWord;
                while (mapTmp.getOrDefault(subRWord, 0) > map.getOrDefault(subRWord, 0)) {
                    String subLWord = s.substring(l, l + oneWord);
                    cnt--;
                    mapTmp.put(subLWord, mapTmp.getOrDefault(subLWord, 0) - 1);
                    l += oneWord;
                }
                if (cnt == wordsLen) res.add(l);
            }
        }
        return res;
    }
    
}
