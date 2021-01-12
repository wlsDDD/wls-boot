package leetcode;

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int index = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = index;
                index++;
                
            }
        }
        return answer;
    }
}