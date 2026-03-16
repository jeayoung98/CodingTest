import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());

            int left = Math.min(x, y);
            int right = Math.max(x, y);

            sb.append(query(0, N - 1, 1, left, right)).append('\n');
            update(0, N - 1, 1, a, b);
        }

        System.out.print(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, long val) {
        if (index < start || index > end) return;

        tree[node] += val - arr[index];

        if (start == end) {
            arr[index] = val;
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, val);
        update(mid + 1, end, node * 2 + 1, index, val);
    }
}