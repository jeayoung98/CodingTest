import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        long[] arr = new long[1_000_001];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length; j++) {
                max = Math.max(max, input[j]);
                min = Math.min(min, input[j]);
            }
            for (int j = input[0]; j < input[1]; j++) {
                arr[j]++;
            }
        }

        for (int i = 1; i <= max; i++) {
            arr[i] += arr[i - 1];
        }

        int left = 0;
        int right = 0;
        int x = 0;
        int y = 0;
        boolean isFound = false;
        while (right <= max) {
            long currentSum;
            if (right == 0) {
                currentSum = 0;
            } else if (left == 0) {
                currentSum = arr[right - 1];
            } else {
                currentSum = arr[right - 1] - arr[left - 1];
            }

            if (currentSum == M) {
                isFound = true;
                x = left;
                y = right;
                break;
            }

            if (currentSum < M) {
                right++;
            } else {
                left++;
                if (left > right) {
                    right = left;
                }
            }
        }
        if (!isFound) System.out.println("0 0");
        else System.out.printf("%d %d",x,y);
    }
}