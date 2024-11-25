import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] sum = new long[N+1];
        sum[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i-1];
        }
        for (int i = 0; i < M; i++) {
            int[] K = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long result = sum[K[1]]-sum[K[0]-1];
            System.out.println(result);
        }
    }
}
