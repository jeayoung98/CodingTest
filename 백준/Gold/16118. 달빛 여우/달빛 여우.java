import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost, state;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public Edge(int to, int cost, int state) {
            this.to = to;
            this.cost = cost;
            this.state = state;
        }
    }

    static List<Edge>[] edgeList;
    static int N;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList[a].add(new Edge(b, cost * 2));
            edgeList[b].add(new Edge(a, cost * 2));
        }

        int result = 0;
        int[] wolf = dijkstra(true);
        int[] fox = dijkstra(false);

        for (int i = 2; i <= N; i++) {
            if (wolf[i] > fox[i]) result++;
        }

        System.out.println(result);
    }

    public static int[] dijkstra(boolean isWolf) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        if (!isWolf) {
            int[] dist = new int[N + 1];
            Arrays.fill(dist, INF);

            dist[1] = 0;
            pq.add(new Edge(1, 0));

            while (!pq.isEmpty()) {
                Edge current = pq.poll();
                int ct = current.to;
                int cc = current.cost;

                if (cc > dist[ct]) continue;

                for (Edge next : edgeList[ct]) {
                    int nt = next.to;
                    int nc = cc + next.cost;

                    if (dist[nt] > nc) {
                        dist[nt] = nc;
                        pq.add(new Edge(nt, nc));
                    }
                }
            }

            return dist;
        } else {
            int[][] dist = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], INF);
            }

            dist[1][0] = 0;
            pq.add(new Edge(1, 0, 0));

            while (!pq.isEmpty()) {
                Edge current = pq.poll();
                int ct = current.to;
                int cc = current.cost;
                int state = current.state;

                if (cc > dist[ct][state]) continue;

                for (Edge edge : edgeList[ct]) {
                    int nt = edge.to;
                    int nc;
                    int nextState;

                    if (state == 0) {
                        nc = cc + edge.cost / 2;
                        nextState = 1;
                    } else {
                        nc = cc + edge.cost * 2;
                        nextState = 0;
                    }

                    if (dist[nt][nextState] > nc) {
                        dist[nt][nextState] = nc;
                        pq.add(new Edge(nt, nc, nextState));
                    }
                }
            }

            return calMin(dist);
        }
    }

    public static int[] calMin(int[][] dist) {
        int[] result = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            result[i] = Math.min(dist[i][0], dist[i][1]);
        }
        return result;
    }
}