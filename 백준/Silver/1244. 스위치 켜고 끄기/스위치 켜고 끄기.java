import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] M = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int s = M[0];
            for (int j = 1; j < M.length; j++) {
                int currentNum = M[j];
                int index = currentNum - 1;

                if (s == 1) {
                    while (index < arr.length) {
                        arr[index] = 1 - arr[index];
                        index += currentNum;
                    }
                } else {
                    arr[index] = 1 - arr[index];
                    int left = index - 1, right = index + 1;
                    while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
                        arr[left]  = 1 - arr[left];
                        arr[right] = 1 - arr[right];
                        left--; right++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
            if (i % 20 == 19) sb.append('\n');
        }
        System.out.print(sb);
    }
}
