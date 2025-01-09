import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] seq = new int[N + 1];
        for (int i = 0; i < arr.length; i++) {
            seq[arr[i]] = i + 1;
        }
        int lisLen = 1;
        int currentLen = 1;
        for (int i = 1; i < N; i++) {
            if (seq[i] < seq[i + 1]) currentLen++;
            else currentLen = 1;

            lisLen = Math.max(lisLen, currentLen);
        }
        System.out.println(N - lisLen);
    }
}
