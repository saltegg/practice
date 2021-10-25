package fzu.com.lc.pre200;

public class Solution414 {

    public int thirdMax(int[] nums) {

        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        //long MIN_V = Long.MIN_VALUE;
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
