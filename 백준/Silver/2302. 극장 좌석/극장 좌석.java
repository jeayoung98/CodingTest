import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int M = Integer.parseInt(br.readLine());
        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int result = 1;
        int last = 0;
        for (int i = 0; i < M; i++) {
            int count = vip[i] - last - 1;
            result *= dp[count];
            last = vip[i];
        }
        result *= dp[N - last];

        System.out.println(result);
    }
}
