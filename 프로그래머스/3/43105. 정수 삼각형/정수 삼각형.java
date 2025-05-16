import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];
        dp[0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = i; j >= 0; j--) {
                int left  = (j > 0) ? dp[j - 1] : -1;
                int right = (j < i) ? dp[j] : -1;
                dp[j] = Math.max(left, right) + triangle[i][j];
            }
        }
        
        return Arrays.stream(dp).max().orElse(-1);
    }
}