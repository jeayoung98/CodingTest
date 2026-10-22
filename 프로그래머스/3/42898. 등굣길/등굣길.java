
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            dp[y - 1][x - 1] = -1;
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) continue;

                if (i > 0 && dp[i - 1][j] != -1) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 0 && dp[i][j - 1] != -1) {
                    dp[i][j] += dp[i][j - 1];
                }

                dp[i][j] %= MOD;
            }
        }

        return dp[n - 1][m - 1];
    }
}
