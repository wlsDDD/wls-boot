package leetcode;

import org.junit.jupiter.api.Test;

/**
 * 统计所有小于非负整数 n 的质数的数量
 */
class Solution204 {
    
    @Test
    public void test01() {
        int i = countPrimes(10);
        System.out.println("i = " + i);
    }
    
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}