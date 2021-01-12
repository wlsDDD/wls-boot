package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution976 {
    
    @Test
    public void test01() {
        int[] array = new int[]{1, 2, 1};
        int i = largestPerimeter(array);
        System.out.println("i = " + i);
    }
    
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int i = 1;
        int a = A[A.length - i];
        int b = A[A.length - i - 1];
        int c = A[A.length - i - 2];
        while ((b + c) <= a) {
            i++;
            if (A.length - i - 2 < 0) {
                return 0;
            }
            a = A[A.length - i];
            b = A[A.length - i - 1];
            c = A[A.length - i - 2];
        }
        return a + b + c;
    }
}