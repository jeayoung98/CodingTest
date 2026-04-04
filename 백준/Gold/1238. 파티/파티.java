import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static List<Edge>[] edgeList;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        edgeList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList[from].add(new Edge(to, cost));
        }

        int max = 0;
        int[] distArr = dijkstraAll(K);

        for (int i = 1; i <= N; i++) {
            max = Math.max(dijkstra(i, K) + distArr[i], max);
        }
        System.out.println(max);

    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int to = current.to;
            int cost = current.cost;

            if (cost > dist[to]) continue;

            if (to == end) break;

            for (Edge edge : edgeList[to]) {
                int nt = edge.to;
                int nc = edge.cost;

                if (cost + nc < dist[nt]) {
                    dist[nt] = cost + nc;
                    pq.add(new Edge(nt, dist[nt]));
                }
            }
        }

        return dist[end];
    }

    public static int[] dijkstraAll(int start) {
        int[] dist = new int[N + 1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int to = current.to;
            int cost = current.cost;

            if (cost > dist[to]) continue;

            for (Edge edge : edgeList[to]) {
                int nt = edge.to;
                int nc = edge.cost;

                if (cost + nc < dist[nt]) {
                    dist[nt] = cost + nc;
                    pq.add(new Edge(nt, dist[nt]));
                }
            }
        }

        return dist;
    }
}