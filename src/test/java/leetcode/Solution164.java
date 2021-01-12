package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution164 {
    
    @Test
    public void test01() {
        int[] nums = {3, 6, 9, 1};
        int i = maximumGap(nums);
        System.out.println("i = " + i);
    }
    
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            answer = Math.max(answer, nums[i + 1] - nums[i]);
        }
        return answer;
    }
}