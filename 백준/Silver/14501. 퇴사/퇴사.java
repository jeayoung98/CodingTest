import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] days = new int[N + 1];
        int[] pays = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            int[] k = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            days[i] = k[0];
            pays[i] = k[1];
        }

        int[] dp = new int[N + 2];

        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);

            if(i + days[i] <= N + 1) {
                dp[i + days[i] -1] = Math.max(dp[i + days[i] -1], dp[i-1] + pays[i]);
            }
        }

        System.out.println(Arrays.stream(dp).max().orElse(-1));
    }
}
