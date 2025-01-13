import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] count = new int[100_001];
        int left = 0;
        int max = 0;
        for (int right = 0; right < arr.length; right++) {
            int current = arr[right];
            count[current]++;

            while (count[current] > N) {
                count[arr[left]]--;
                left++;
            }

            int currentLen = right - left + 1;
            max = Math.max(max, currentLen);
        }

        System.out.println(max);
    }
}
