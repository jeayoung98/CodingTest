
import java.util.*;

class Solution {
    class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    List<Edge>[] edgeList;
    int N;
    boolean[] isSummit;
    boolean[] isGate;
    int[] summits;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.N = n;
        this.summits = summits;

        isSummit = new boolean[n + 1];
        isGate = new boolean[n + 1];

        for (int summit : summits) {
            isSummit[summit] = true;
        }

        for (int gate : gates) {
            isGate[gate] = true;
        }

        edgeList = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int cost = path[2];

            edgeList[a].add(new Edge(b, cost));
            edgeList[b].add(new Edge(a, cost));
        }

        return dijkstra(gates);
    }

    public int[] dijkstra(int[] gates) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.add(new Edge(gate, 0));
            dist[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int to = current.to;
            int cost = current.cost;

            if (dist[to] < cost) continue;

            // 산봉우리에서는 더 이동하지 않음
            if (isSummit[to]) continue;

            for (Edge edge : edgeList[to]) {
                // 출입구를 중간 경유지로 사용하지 않음
                if (isGate[edge.to]) continue;

                int nextCost = Math.max(cost, edge.cost);

                if (dist[edge.to] > nextCost) {
                    dist[edge.to] = nextCost;
                    pq.add(new Edge(edge.to, nextCost));
                }
            }
        }

        Arrays.sort(summits);

        int summit = -1;
        int intensity = Integer.MAX_VALUE;

        for (int s : summits) {
            if (dist[s] < intensity) {
                summit = s;
                intensity = dist[s];
            }
        }

        return new int[]{summit, intensity};
    }
}
