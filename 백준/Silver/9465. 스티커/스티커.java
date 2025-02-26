import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int M = Integer.parseInt(br.readLine());

            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] dp = new int[M+1][3];

            dp[1][0] = 0;
            dp[1][1] = a[0];
            dp[1][2] = b[0];

            for(int i = 2; i <= M; i++){
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + a[i - 1];
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + b[i - 1];
            }

            int answer = Math.max(dp[M][0], Math.max(dp[M][1], dp[M][2]));
            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }
}
