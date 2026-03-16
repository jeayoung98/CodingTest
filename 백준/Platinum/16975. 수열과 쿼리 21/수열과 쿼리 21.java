import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int now;
        add(1, prev);
        for (int i = 2; i <= N; i++) {
            now = Integer.parseInt(st.nextToken());
            add(i, now - prev);
            prev = now;
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int b = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                add(a, k);
                add(b + 1, -k);
            } else {
                sb.append(sum(a)).append("\n");
            }

        }
        System.out.println(sb);

    }

    public static void add(int pos, int val) {
        while (pos <= N) {
            tree[pos] += val;
            pos += (pos & -pos);
        }
    }

    public static long sum(int pos) {
        long result = 0;
        while (pos > 0) {
            result += tree[pos];
            pos &= (pos - 1);
        }
        return result;
    }
}