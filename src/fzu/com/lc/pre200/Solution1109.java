package fzu.com.lc.pre200;

public class Solution1109 {

    public int[] corpFlightBookings1(int[][] bookings, int n) {

        int[] answer = new int[n];
        for (int[] booking : bookings) {
            for (int j = booking[0] - 1; j <= booking[1] - 1; j++) {
                answer[j] += booking[2];
            }
        }
        return answer;
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;

    }
}
