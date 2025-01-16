import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] lastIndex = new int[100001];
        Arrays.fill(lastIndex, -1);

        long result = 0;
        int left = 0;

        for(int right = 0; right < N; right++) {
            int current = arr[right];
            if(lastIndex[current] >= left) {
                left = lastIndex[current] + 1;
            }

            lastIndex[current] = right;

            result += (right - left + 1);
        }

        System.out.println(result);
    }
}
