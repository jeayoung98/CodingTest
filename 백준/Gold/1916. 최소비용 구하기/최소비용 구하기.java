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
    static int N;
    static List<Edge>[] edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        edgeList = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Edge(start, 0));

        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.to == end) return current.cost;
            if (dist[current.to] < current.cost) continue;
            for (Edge e : edgeList[current.to]) {
                int cc = current.cost + e.cost;
                if (dist[e.to] > cc) {
                    dist[e.to] = cc;
                    pq.add(new Edge(e.to, cc));
                }
            }
        }
        return -1;
    }
}