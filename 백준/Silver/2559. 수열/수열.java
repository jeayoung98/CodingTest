import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            sum += array[i];
            if (i - left + 1 == M) {
                result = Math.max(sum, result);
                sum -= array[left];
                left++;
            }
        }
        System.out.println(result);
    }
}
