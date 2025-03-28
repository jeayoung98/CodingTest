import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        if (arr.length == 2) {
            System.out.println(dp[1]);
            return;
            
        }
        dp[2] = Math.max(Math.max(arr[0] + arr[2], arr[1] + arr[2]), dp[1]);


        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }

        System.out.println(dp[n-1]);
    }
}
