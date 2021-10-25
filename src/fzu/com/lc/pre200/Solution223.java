package fzu.com.lc.pre200;

public class Solution223 {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s = 0;
        if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || ay1 >= by2) {
            s = 0;
        } else {
            int x1 = Math.max(ax1, bx1);
            int x2 = Math.min(ax2, bx2);

            int y1 = Math.max(ay1, by1);
            int y2 = Math.min(ay2, by2);

            s = (x2 - x1) * (y2 - y1);
        }
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - s;
    }

    public static void main(String[] args) {
        computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
    }
}
