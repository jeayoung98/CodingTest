import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int max = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > max - 1) {
                result += Math.abs(max - 1 - arr[i]);
                max--;
            } else {
                max = arr[i];
            }
        }

        System.out.println(result);
    }
}
