import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long max = cal(arr, M);
            sb.append(max).append("\n");
        }
        
        System.out.print(sb.toString());
    }

    public static long cal(int[] arr, int N) {
        long profit = 0;
        long maxPrice = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > maxPrice) {
                maxPrice = arr[i];
            }
            profit += maxPrice - arr[i];
        }
        return profit;
    }
}
