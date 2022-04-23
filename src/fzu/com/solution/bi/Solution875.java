package fzu.com.solution.bi;

public class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int l = 1, r = maxPile;
        while (l < r) {
            int hours = 0;
            int mid = l + (r - l) / 2;
            for (int pile : piles) {
                if (pile % mid == 0) {
                    hours += pile / mid;
                } else {
                    hours += pile / mid + 1;
                }
            }
            if (hours <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
