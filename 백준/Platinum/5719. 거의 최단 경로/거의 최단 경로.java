import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M, S, D;
    static List<Edge>[] graph;
    static List<Integer>[] prev;
    static boolean[][] removed;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N];
            prev = new ArrayList[N];
            removed = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                prev[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                graph[u].add(new Edge(v, p));
            }

            dijkstra(S);
            removePath(D);
            dijkstra(S);

            sb.append(dist[D] == INF ? -1 : dist[D]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        dist = new int[N];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        for (int i = 0; i < N; i++) {
            prev[i].clear();
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.cost > dist[current.to]) continue;

            for (Edge next : graph[current.to]) {
                if (removed[current.to][next.to]) continue;

                int nd = current.cost + next.cost;

                if (nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.add(new Edge(next.to, nd));

                    prev[next.to].clear();
                    prev[next.to].add(current.to);
                } else if (nd == dist[next.to]) {
                    prev[next.to].add(current.to);
                }
            }
        }
    }

    public static void removePath(int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(end);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (visited[current]) continue;
            visited[current] = true;

            for (int p : prev[current]) {
                removed[p][current] = true;
                queue.add(p);
            }
        }
    }
}