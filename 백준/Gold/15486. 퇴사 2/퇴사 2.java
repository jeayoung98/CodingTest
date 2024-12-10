import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] days = new int[N + 1];
        int[] pays = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            days[i] = Integer.parseInt(s[0]);
            pays[i] = Integer.parseInt(s[1]);
        }

        int[] dp = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            if (i + days[i] - 1 <= N) {
                dp[i] = Math.max(pays[i] + dp[i + days[i]], dp[i + 1]);
            } else dp[i] = dp[i + 1];
        }
        System.out.println(dp[1]);
    }
}
