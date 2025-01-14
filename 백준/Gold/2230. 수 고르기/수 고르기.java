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

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int left = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {
            if (arr[right] - arr[left] >= M) {
                result = Math.min(result, arr[right] - arr[left]);
                left++;
                right--;
            }
            if (left > right) right = left;
        }

        System.out.println(result);
    }
}
