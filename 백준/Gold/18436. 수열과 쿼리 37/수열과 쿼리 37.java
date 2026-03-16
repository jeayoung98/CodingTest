import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[N];
        tree = new long[N * 4];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken()) % 2;
        }

        init(0, N - 1, 1);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            if (x == 1) {
                update(0, N - 1, 1, a, b);
            } else {
                b -= 1;
                long oddCount = query(0, N - 1, 1, a, b);

                if (x == 2) {
                    sb.append((b - a + 1) - oddCount).append("\n");
                } else {
                    sb.append(oddCount).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static void update(int start, int end, int node, int index, int val) {
        if (index < start || index > end) return;

        long newVal = val % 2;
        tree[node] += newVal - arr[index];

        if (start == end) {
            arr[index] = newVal;
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, val);
        update(mid + 1, end, node * 2 + 1, index, val);
    }

    public static long query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }
}