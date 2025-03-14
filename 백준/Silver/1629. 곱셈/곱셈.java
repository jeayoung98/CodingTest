import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = array[0];
        M = array[1];
        K = array[2];

        System.out.println(pow(M));
    }

    public static long pow(long depth) {
        if (depth == 0L) return 1;
        if (depth == 1L) return N % K;
        long half = pow(depth / 2);
        long result = (half * half) % K;

        if (depth % 2 == 1) {
            result = (result * (N % K)) % K;
        }

        return result;
    }
}