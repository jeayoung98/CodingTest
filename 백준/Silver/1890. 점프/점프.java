import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(dfs(0, 0));
    }

    static long dfs(int i, int j) {
        if (i == N - 1 && j == N - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;
        int jump = board[i][j];
        if(jump == 0) return dp[i][j];

        if (j + jump < N) {
            dp[i][j] += dfs(i, j + jump);
        }
        if (i + jump < N) {
            dp[i][j] += dfs(i + jump, j);
        }

        return dp[i][j];
    }
}
