import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(snacks);
        int result = getResult(snacks, N, M);

        System.out.println(result);
    }

    private static int getResult(int[] snacks, int N, int M) {
        int max = snacks[snacks.length - 1];

        int left = 1;
        int right = max;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int total = 0;

            for(int i = 0; i < M; i++) {
                total += (snacks[i] / mid);
                if(total >= N) break;

            }

            if(total >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
