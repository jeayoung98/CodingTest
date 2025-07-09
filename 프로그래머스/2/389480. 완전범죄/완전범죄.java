import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int totalA = 0;
        for (int[] a : info) totalA += a[0];

        int[] dp = new int[m];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int[] i : info) {
            int a = i[0], b = i[1];
            for (int cap = m - 1; cap >= b; cap--) {
                if (dp[cap - b] != -1) {
                    dp[cap] = Math.max(dp[cap], dp[cap - b] + a);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[i] == -1) continue;
            int aLeft = totalA - dp[i];
            if (aLeft < n) answer = Math.min(answer, aLeft);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
