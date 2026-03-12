import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int N;
    static List<Edge>[] edgeList;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = read();
            int D = read();
            int C = read();

            edgeList = new List[N + 1];
            for (int j = 1; j <= N; j++) {
                edgeList[j] = new ArrayList<>();
            }

            for (int j = 0; j < D; j++) {
                st = new StringTokenizer(br.readLine());
                int a = read();
                int b = read();
                int s = read();

                edgeList[b].add(new Edge(a, s));
            }

            int[] dist = dijkstra(C);

            int count = 0;
            int time = 0;

            for (int j = 1; j <= N; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    count++;
                    time = Math.max(time, dist[j]);
                }
            }

            sb.append(count).append(" ").append(time).append("\n");
        }

        System.out.print(sb);
    }

    public static int read() {
        return Integer.parseInt(st.nextToken());
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.cost > dist[current.to]) continue;

            for (Edge next : edgeList[current.to]) {
                int newDist = dist[current.to] + next.cost;

                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.offer(new Edge(next.to, newDist));
                }
            }
        }

        return dist;
    }
}