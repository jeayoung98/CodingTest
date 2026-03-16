import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long val = Long.parseLong(st.nextToken());
            arr[i] = val;
            add(i, val);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = Math.min(x, y);
            int end = Math.max(x, y);

            sb.append(rangeSum(start, end)).append("\n");
            update(a,b);
        }
        System.out.println(sb);
    }

    public static void add(int pos, long val) {
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

    public static long rangeSum(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    public static void update(int idx, long val) {
        long diff = val - arr[idx];
        arr[idx] = val;
        add(idx,diff);
    }

}