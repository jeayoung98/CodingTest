import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static List<Edge>[] edgeList;
    static int N, M, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList[idx].add(new Edge(to, w));
            edgeList[to].add(new Edge(idx, w));

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
        System.out.println(result);
    }

    public static void dijkstra(int start, int end) {
        final int INF = Integer.MAX_VALUE;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int cL = current.to;
            int cD = current.w;

            if (visited[cL]) continue;
            visited[cL] = true;

            if (cL == end) {
                result = cD;
                break;
            }

            for (Edge e : edgeList[cL]) {
                if (!visited[e.to] && dist[e.to] > dist[cL] + e.w) {
                    dist[e.to] = dist[cL] + e.w;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
    }
}