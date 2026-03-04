import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static long[] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = (int) read();
        int M = (int) read();
        int K = (int) read();

        arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());

        tree = new long[N * 4];
        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = (int) read();
            long a = read();
            long b = read();

            if (cmd == 1) {
                int idx = (int) a - 1;
                long diff = b - arr[idx];
                arr[idx] = b;
                update(0, N - 1, 1, idx, diff);
            } else {
                int left = (int) a - 1;
                int right = (int) b - 1;
                sb.append(query(0, N - 1, 1, left, right)).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int idx, long value) {
        if (idx < start || idx > end) return;
        tree[node] += value;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, value);
        update(mid + 1, end, node * 2 + 1, idx, value);
    }

    public static long read() {
        return Long.parseLong(st.nextToken());
    }
}