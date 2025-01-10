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
        int K = Integer.parseInt(s[2]);
        int Q = Integer.parseInt(s[3]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] freq = new int[M + 1];
        int count = 0;

        for (int i = 0; i < K; i++) {
            if (freq[arr[i]] == 0) {
                count++;
            }
            freq[arr[i]]++;
        }

        int result = count;
        if (freq[Q] == 0) {
            result++;
        }
        
        for (int start = 1; start < N; start++) {
            int removeSushi = arr[start - 1];
            freq[removeSushi]--;
            if (freq[removeSushi] == 0) {
                count--;
            }
            int newSushi = arr[(start + K - 1) % N];
            if (freq[newSushi] == 0) {
                count++;
            }
            freq[newSushi]++;
            
            int currentResult = count;
            if (freq[Q] == 0) {
                currentResult++;
            }
            
            result = Math.max(result, currentResult);
        }

        System.out.println(result);
    }
}
