package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-(c + d))) {
                    answer += map.get(-(c + d));
                }
            }
        }
        return answer;
    }
}