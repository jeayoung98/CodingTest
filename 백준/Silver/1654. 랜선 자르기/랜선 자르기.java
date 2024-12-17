import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        long[] arr = new long[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long result = binarySearch(arr, M, max);
        System.out.println(result);
    }

    public static long binarySearch(long[] arr, int M, long max) {
        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;

            for (long num : arr) {
                sum += num / mid;
            }

            if (sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
