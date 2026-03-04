import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] arr;
    static long[] minTree, maxTree;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = (int) read();
        M = (int) read();

        arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());

        minTree = new long[N * 4];
        maxTree = new long[N * 4];

        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = (int) read() - 1;
            int b = (int) read() - 1;

            long min = queryMin(0, N - 1, 1, a, b);
            long max = queryMax(0, N - 1, 1, a, b);

            sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }

    static void init(int start, int end, int node) {
        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static long queryMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Long.MAX_VALUE;
        if (left <= start && end <= right) return minTree[node];
        int mid = (start + end) / 2;
        return Math.min(queryMin(start, mid, node * 2, left, right), queryMin(mid + 1, end, node * 2 + 1, left, right)
        );
    }

    static long queryMax(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Long.MIN_VALUE;
        if (left <= start && end <= right) return maxTree[node];
        int mid = (start + end) / 2;
        return Math.max(
                queryMax(start, mid, node * 2, left, right),
                queryMax(mid + 1, end, node * 2 + 1, left, right)
        );
    }

    static long read() {
        return Long.parseLong(st.nextToken());
    }
}