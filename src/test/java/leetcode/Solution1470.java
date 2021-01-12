package leetcode;

class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] a = new int[nums.length];
        int index1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                a[i] = nums[index1];
                index1++;
            } else {
                a[i] = nums[n];
                n++;
            }
        }
        return a;
    }
}