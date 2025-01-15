import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right < N; right++) {
            sum += arr[right];
            while(sum >= M) {
                result = Math.min(result, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
