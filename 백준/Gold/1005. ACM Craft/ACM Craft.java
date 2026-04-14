import java.io.*;
import java.util.*;

public class Main {
    static int[] indegree, dp, time;
    static List<Integer>[] edgeList;

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            indegree = new int[N + 1];
            dp = new int[N + 1];

            edgeList = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                edgeList[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
                dp[j] = time[j];
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edgeList[a].add(b);
                indegree[b]++;
            }
            TopologySort();
            int K = Integer.parseInt(br.readLine());

            sb.append(dp[K]).append('\n');
        }

        System.out.print(sb);
    }

    public static void TopologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 1; j <= N; j++) {
            if (indegree[j] == 0) {
                queue.add(j);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : edgeList[current]) {
                dp[next] = Math.max(dp[next], dp[current] + time[next]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}