package fzu.com.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution229 {

    /*
    计数法
     */
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        for (int k : map.keySet()) {
            int v = map.get(k);
            if (v > nums.length / 3) list.add(k);
        }
        return list;
    }

    /*
        摩尔投票法升级版
     */
    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (null == nums || nums.length == 0) return list;
        int can1 = 0, can2 = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == can1) {
                count1++;
                continue;
            }
            if (num == can2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                can1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                can2 = num;
                count1++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == can1) count1++;
            else if (num == can2) count2++;
        }
        if (count1 > nums.length / 3) list.add(can1);
        if (count2 > nums.length / 3) list.add(can2);
        return list;
    }

    public static void main(String[] args) {
        
    }

}
