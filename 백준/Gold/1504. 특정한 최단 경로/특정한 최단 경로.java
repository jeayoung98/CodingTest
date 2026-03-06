import java.io.*;
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
    static int a,b;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new List[N + 1];

        for (int i = 0; i < N + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList[from].add(new Edge(to, cost));
            edgeList[to].add(new Edge(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int path1 = dijkstra(1, a) + dijkstra(a, b) + dijkstra(b, N);
        int path2 = dijkstra(1, b) + dijkstra(b, a) + dijkstra(a, N);
        int result = Math.min(path2,path1);
        System.out.println(result < 0 ? -1 : result);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.to == end) return current.cost;
            if (current.cost > dist[current.to]) continue;
            for (Edge e : edgeList[current.to]) {
                int nextCost = current.cost + e.cost;
                if (nextCost < dist[e.to]) {
                    dist[e.to] = nextCost;
                    pq.add(new Edge(e.to, nextCost));
                }
            }
        }
        return -100_000_000;
    }
}