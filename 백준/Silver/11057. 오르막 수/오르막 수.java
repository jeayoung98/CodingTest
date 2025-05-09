import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum % 10007;
            }
        }

        int result = 0;
        for (int j = 0; j < 10; j++) {
            result = (result + dp[N][j]) % 10007;
        }

        System.out.println(result);
    }
}
