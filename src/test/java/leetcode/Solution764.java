package leetcode;

class Solution764 {
    public int minCostClimbingStairs(int[] cost) {
        int answer = 0;
        int index = 0;
        int min1 = Math.min(cost[0], cost[1]);
        answer += min1;
        if (min1 == cost[1]) {
            index = 1;
        }
        while (index + 2 < cost.length) {
            int min = Math.min(cost[index + 2], cost[index + 3]);
            answer += min;
            if (min == cost[index + 3]) {
                index += 2;
            } else {
                index++;
            }
        }
        return answer;
    }
}