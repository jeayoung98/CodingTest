import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j-1] + price[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
