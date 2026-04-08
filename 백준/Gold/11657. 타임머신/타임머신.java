import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

    static long[] dist;
    static int V, E;
    static List<Edge> edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new long[V + 1];
        edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        bellmanFord(1);

        System.out.print(sb);

    }

    private static void bellmanFord(int start) {
        final long INF = Long.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            boolean flag = false;
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }

        boolean negativeCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                negativeCycle = true;
                break;
            }
        }
        if (negativeCycle) {
            sb.append("-1").append("\n");
            return;
        }

        for (int i = 2; i <= V; i++) {
            if (dist[i] >= INF) {
                sb.append("-1").append("\n");
            } else
                sb.append(dist[i]).append("\n");
        }
    }
}