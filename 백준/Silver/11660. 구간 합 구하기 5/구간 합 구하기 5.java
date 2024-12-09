import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = a[0];
        int M = a[1];
        int[][] arr = new int[N][N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int[] k = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < k.length; j++) {
                sum += k[j];
                arr[i][j] = sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int currentSum = 0;
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] x = new int[]{array[0] - 1, array[1] - 1};
            int minX = array[1] - 2;
            if (array[1] == 1) {
                minX = 0;
            }

            int[] y = new int[]{array[2] - 1, array[3] - 1};
            for (int j = x[0]; j <= y[0]; j++) {
                if (x[1] == 0) {
                    if (j != 0) {
                        currentSum += arr[j][y[1]] - arr[j - 1][arr[0].length - 1];
                    }else currentSum = arr[j][y[1]];
                }else currentSum += arr[j][y[1]] - arr[j][minX];
            }
            sb.append(currentSum).append("\n");
        }
        System.out.println(sb.toString());
    }
}
