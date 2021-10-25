package fzu.com.lc.pointOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Offer45 {

    public String minNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int v : nums) strs.add(String.valueOf(v));
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }
}
