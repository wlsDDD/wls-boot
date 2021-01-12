package leetcode;

import org.junit.jupiter.api.Test;

class Solution34 {
    
    @Test
    public void test01() {
        int[] nums = {1, 2, 3};
        int[] ints = searchRange(nums, 3);
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}