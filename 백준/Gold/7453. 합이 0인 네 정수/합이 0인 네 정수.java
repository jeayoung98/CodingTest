import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] sumAB = new int[N * N];
        int[] sumCD = new int[N * N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumAB[idx] = arr[i][0] + arr[j][1];
                sumCD[idx] = arr[i][2] + arr[j][3];
                idx++;
            }
        }

        Arrays.sort(sumCD);

        long result = 0;
        for (int i = 0; i < sumAB.length; i++) {
            int cn = sumAB[i];
            result += (upperBound(sumCD, -cn) - lowerBound(sumCD, -cn));
        }

        System.out.println(result);
    }

    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}