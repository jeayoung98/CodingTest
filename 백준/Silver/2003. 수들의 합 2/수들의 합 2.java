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

        int result = 0;
        int start = 0;
        int end = 0;
        int currentSum = 0;

        while (end <= N) {
            if (currentSum < M) {
                if (end < N) currentSum += array[end++];
                else break;
            } else if (currentSum == M) {
                result++;
                currentSum -= array[start++];
            } else {
                currentSum -= array[start++];
            }
        }

        System.out.println(result);
    }
}
