import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[M];

        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        long result = getResult(a, b, T);

        System.out.println(result);
    }

    private static long getResult(int[] a, int[] b, int T) {
        Map<Long, Integer> preSum = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            long sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }
        }

        long result = 0;
        for (int i = 0; i < b.length; i++) {
            long sum = 0;
            for (int j = i; j < b.length; j++) {
                sum += b[j];
                result += preSum.getOrDefault(T - sum, 0);
            }
        }
        return result;
    }
}