class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;

        int[][] diff = new int[n + 1][m + 1];
        
        int answer = 0;

        for (int[] s : skill) {
            int type = s[0];
            int x1 = s[1];
            int y1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            int degree = s[5];

            int value = type == 1 ? -degree : degree;

            diff[x1][y1] += value;
            diff[x1][y2 + 1] -= value;
            diff[x2 + 1][y1] -= value;
            diff[x2 + 1][y2 + 1] += value;
        }

        // 행 누적합
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 열 누적합
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                diff[j][i] += diff[j - 1][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}