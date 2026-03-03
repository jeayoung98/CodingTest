import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to,w;
        
        public Edge(int to, int w) { 
            this.to = to; this.w = w; 
        }
        
        @Override public int compareTo(Edge o) { 
            return Integer.compare(this.w, o.w); 
        }
    }

    static StringTokenizer st;
    static int N, M, K;
    static List<Edge>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = read();
        M = read();
        K = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {                 
            st = new StringTokenizer(br.readLine());
            int idx = read();
            int to = read();
            int w = read();
            list[idx].add(new Edge(to, w));
        }

        int[] dist = dijkstra();                  
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static int read() { return Integer.parseInt(st.nextToken()); }

    public static int[] dijkstra() {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (dist[current.to] < current.w) continue;
            for (Edge e : list[current.to]) {
                int cd = current.w + e.w;
                if (dist[e.to] > cd) {
                    dist[e.to] = cd;
                    pq.add(new Edge(e.to, cd));
                }
            }
        }
        return dist;
    }
}