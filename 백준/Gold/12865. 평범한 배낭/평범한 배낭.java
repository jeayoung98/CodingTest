import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            weights[i] = Integer.parseInt(split[0]);
            values[i] = Integer.parseInt(split[1]);
        }

        int[] dp = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = K; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
