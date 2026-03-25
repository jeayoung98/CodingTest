import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static long[] result;
    static long[] good;
    static List<Integer>[] staff;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        staff = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            staff[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != -1) {
                staff[boss].add(i);
            }
        }

        good = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int staff = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            good[staff] += cost;
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);
    }

    public static void bfs() {
        result = new long[N + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        result[1] = good[1];

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : staff[current]) {
                result[next] = result[current] + good[next];
                queue.add(next);
            }
        }
    }
}