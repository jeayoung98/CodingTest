import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[1]);

        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
            Arrays.sort(arr);
        }
        System.out.println(Arrays.stream(arr).sum());
    }
}