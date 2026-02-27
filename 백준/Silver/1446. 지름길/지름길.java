import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to; this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int v, dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] edgeList = new ArrayList[M + 1];
        for (int i = 0; i <= M; i++) {
            edgeList[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            edgeList[i].add(new Edge(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cheat = Integer.parseInt(st.nextToken());

            if (end > M) continue;
            edgeList[start].add(new Edge(end, cheat));
        }

        int[] dist = new int[M + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.dist != dist[current.v]) continue;
            if (current.v == M) break;

            for (Edge nx : edgeList[current.v]) {
                int nd = current.dist + nx.w;
                if (nd < dist[nx.to]) {
                    dist[nx.to] = nd;
                    pq.add(new Node(nx.to, nd));
                }
            }
        }

        System.out.println(dist[M]);
    }
}