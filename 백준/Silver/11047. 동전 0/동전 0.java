import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            while (true) {
                if (result + arr[i] <= M) {
                    result += arr[i];
                    count++;
                } else break;
            }
            
        }

        System.out.println(count);
    }
}
