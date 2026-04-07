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
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList[a].add(new Edge(b, cost));
            edgeList[b].add(new Edge(a, cost));
        }
        System.out.println(prim(1));


    }

    public static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Edge(start, 0));

        int total = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.to]) continue;

            visited[current.to] = true;
            total += current.cost;
            cnt++;

            if (cnt == N) break;

            for (Edge next : edgeList[current.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        if (cnt != N) return -1;

        return total;
    }
}