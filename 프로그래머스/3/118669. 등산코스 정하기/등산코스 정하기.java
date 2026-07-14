import java.util.*;

class Solution {

    class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    class Node {
        int number;
        int intensity;

        Node(int number, int intensity) {
            this.number = number;
            this.intensity = intensity;
        }
    }

    List<Edge>[] graph;
    boolean[] isSummit;
    final int INF = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        makeGraph(n, paths);

        isSummit = new boolean[n + 1];

        for (int summit : summits) {
            isSummit[summit] = true;
        }

        int[] intensity = dijkstra(n, gates);

        return findAnswer(summits, intensity);
    }

    public void makeGraph(int n, int[][] paths) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int weight = path[2];

            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }
    }

    public int[] dijkstra(int n, int[] gates) {
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, INF);

        PriorityQueue<Node> pq =new PriorityQueue<>((a, b) -> Integer.compare(a.intensity, b.intensity));

        init(gates, intensity, pq);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.intensity > intensity[current.number]) {
                continue;
            }

            // 정상에 도착
            if (isSummit[current.number]) {
                continue;
            }

            for (Edge edge : graph[current.number]) {
                int ni = Math.max(current.intensity, edge.weight);

                if (ni >= intensity[edge.to]) {
                    continue;
                }

                intensity[edge.to] = ni;
                pq.add(new Node(edge.to, ni));
            }
        }

        return intensity;
    }

    public void init(int[] gates, int[] intensity, PriorityQueue<Node> pq) {
        // 시작점 모두 넣음
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.add(new Node(gate, 0));
        }
    }

    public int[] findAnswer(int[] summits, int[] intensity) {
        Arrays.sort(summits);

        int currentS = 0;
        int mi = INF;

        for (int summit : summits) {
            if (intensity[summit] < mi) {
                currentS = summit;
                mi = intensity[summit];
            }
        }

        return new int[]{currentS, mi};
    }
}