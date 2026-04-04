import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            int[] indegree = new int[N + 1];
            int[] dp = new int[N + 1];

            List<Integer>[] graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
                dp[j] = time[j];
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph[X].add(Y);
                indegree[Y]++;
            }

            int K = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j <= N; j++) {
                if (indegree[j] == 0) {
                    queue.add(j);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    dp[next] = Math.max(dp[next], dp[current] + time[next]);
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            sb.append(dp[K]).append('\n');
        }

        System.out.print(sb);
    }
}