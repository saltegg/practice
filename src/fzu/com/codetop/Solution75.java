package fzu.com.codetop;

public class Solution75 {

        public void sortColors(int[] nums) {

            int l = 0, r = nums.length - 1;

            for (int pos = 0; pos <= r; pos++) {
                if (nums[pos] == 0) {
                    swap(pos, l, nums);
                    l++;
                } else if (nums[pos] == 1) {
                    continue;
                } else {
                    swap(pos, r, nums);
                    pos--;
                    r--;
                }
            }
        }

        private void swap(int i, int j, int[] nums) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
}
