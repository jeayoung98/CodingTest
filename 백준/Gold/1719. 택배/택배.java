import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to, w, start;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int N, M;
    static List<Edge>[] edgeList;
    static StringBuilder sb = new StringBuilder();
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

        for (int i = 1; i <= N; i++) {
            int[] resultArr = dijkstra(i);
            for (int j = 1; j <= N; j++) {
                if (i == j) sb.append("-").append(" ");
                else sb.append(resultArr[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[] dijkstra(int start) {
        final int INF = Integer.MAX_VALUE;
        int[] resultArr = new int[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int ct = current.to;
            int cw = current.w;

            if(visited[ct]) continue;
            visited[ct] = true;

            for (Edge e : edgeList[ct]) {
                if (!visited[e.to] && dist[e.to] > dist[ct] + e.w) {
                    if (ct == start) resultArr[e.to] = e.to;
                    else resultArr[e.to] = resultArr[ct];
                    dist[e.to] = dist[ct] + e.w;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
        return resultArr;
    }
}