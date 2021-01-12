package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution493 {
    
    @Test
    public void test01() {
        int[] nums = {1, 2, 3, 4, 5};
        int i = reversePairs(nums);
        System.out.println("i = " + i);
        
    }
    
    public int reversePairs(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            answer += (long) Arrays.stream(nums).skip(i + 1).parallel().filter(value -> num > (long) value << 1).count();
        }
        return answer;
    }
}