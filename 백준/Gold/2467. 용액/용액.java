import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = N - 1;
        int max = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < max) {
                max = Math.abs(sum);
                x = arr[left];
                y = arr[right];
            }
            if (sum < 0) left++;
            else right--;
        }
        System.out.println(x + " " + y);
    }
}
