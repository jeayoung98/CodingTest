import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        int[] b = new int[M];

        int result = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }

        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);

        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = 1; j < N; j++) {
                sum += a[(i + j - 1) % N];
                prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
            }
        }

        long as = 0;
        for (int x : a) {
            as += x;
        }
        prefix.put(as, prefix.getOrDefault(as, 0) + 1);
        result += prefix.getOrDefault((long) goal, 0);

        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = 1; j < M; j++) {
                sum += b[(i + j - 1) % M];
                result += prefix.getOrDefault((long) goal - sum, 0);
            }
        }

        long bs = 0;
        for (int x : b){
            bs += x;
        }
        result += prefix.getOrDefault((long) goal - bs, 0);

        System.out.println(result);
    }
}