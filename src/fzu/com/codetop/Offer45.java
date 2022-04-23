package fzu.com.codetop;

import java.util.*;

public class Offer45 {

    public String minNumber(int[] nums) {

        List<String> strs = new ArrayList<>();
        for (int num : nums) strs.add(String.valueOf(num));
        strs.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }
}
