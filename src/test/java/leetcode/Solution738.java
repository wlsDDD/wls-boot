package leetcode;

import org.junit.jupiter.api.Test;

class Solution738 {
    
    @Test
    public void test01() {
        int ans = 663856657;
        
    }
    
    public int monotoneIncreasingDigits(int N) {
        String answer = "";
        if (N < 10) {
            return N;
        }
        String str = N + "";
        char[] chars = str.toCharArray();
        if (chars[0] > chars[chars.length - 1]) {
//            answer = chars[chars.length - 1] + "9".repeat(chars.length - 1);
        } else {
        
        }
        return Integer.parseInt(answer);
    }
    
    public boolean isItMonotonous(String str) {
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 1; i--) {
            if (Integer.parseInt(chars[i] + "") < Integer.parseInt(chars[i - 1] + "")) {
                return false;
            }
        }
        return true;
    }
}