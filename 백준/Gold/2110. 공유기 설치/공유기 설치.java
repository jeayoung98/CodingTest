import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canInstall(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static boolean canInstall(int dist) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
        }

        return count >= M;
    }
}