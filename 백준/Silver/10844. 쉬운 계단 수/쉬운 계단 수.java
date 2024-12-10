import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;

        long[][] dp = new long[N+1][10];

        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][8] % mod;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % mod;
        }

        System.out.println(result);
    }
}
