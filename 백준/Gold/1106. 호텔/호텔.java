import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int customer;
        int cost;

        Node(int customer, int cost) {
            this.customer = customer;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, L;
    static int[] cost, customer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[M];
        customer = new int[M];
        int max = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, customer[i]);
        }

        L = N + max;


        int answer = Integer.MAX_VALUE;
        for (int i = N; i <= L; i++) {
            answer = Math.min(answer, dijkstra()[i]);
        }

        System.out.println(answer);
    }

    public static int[] dijkstra() {
        int[] dist = new int[L + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.customer]) continue;

            for (int i = 0; i < M; i++) {
                int nc = current.customer + customer[i];
                if (nc > L) continue;

                int nextCost = current.cost + cost[i];

                if (dist[nc] > nextCost) {
                    dist[nc] = nextCost;
                    pq.offer(new Node(nc, nextCost));
                }
            }
        }
        return dist;
    }
}