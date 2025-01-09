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

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;
        for (int i = 0; i < N; i++) {
            int currentSum = array[i];
            if (currentSum == M) result++;
            for (int j = i + 1; j < N; j++) {
                currentSum += array[j];
                if (currentSum == M) result++;
                else if (currentSum > M) break;
            }
        }
        System.out.println(result);

    }
}
