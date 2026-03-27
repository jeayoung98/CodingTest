import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int left = 0;
        int right = 0;

        int result = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            arr[i] = current;
            right = Math.max(current, right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            long cr = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid >= 0) {
                    cr += arr[i] - mid;
                }
            }

            if (cr >= M) {
                result = Math.max(mid, result);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}