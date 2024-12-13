import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + (arr[i] == 1 ? 1 : 0);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + ((j % 2 == 0) ? (arr[i] == 1 ? 1 : 0) : (arr[i] == 2 ? 1 : 0));
                }
            }
        }

        System.out.println(Arrays.stream(dp[N]).max().orElse(-1));
    }
}
