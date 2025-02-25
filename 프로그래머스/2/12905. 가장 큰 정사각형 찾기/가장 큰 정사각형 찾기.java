class Solution {
    public int solution(int[][] board) {
        int x = board.length;
        int y = board[0].length;
        
        int max = 0;
        
        int[][] dp = new int[x][y];
        
        for (int j = 0; j < y; j++) {
            dp[0][j] = board[0][j];
            if (dp[0][j] > max) {
                max = dp[0][j];
            }
        }
        
        for (int i = 0; i < x; i++) {
            dp[i][0] = board[i][0];
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return (int) Math.pow(max,2);
    }
}
