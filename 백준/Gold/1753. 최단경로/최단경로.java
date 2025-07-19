import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<List<Node>> list = new ArrayList<>();

    static class Node {
        int next, cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = s[0];
        M = s[1];
        K = Integer.parseInt(br.readLine()); // 시작 정점

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(arr[0]).add(new Node(arr[1], arr[2]));
        }

        int[] result = dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i] == Integer.MAX_VALUE ? "INF" : result[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (dist[current.next] < current.cost) {
                continue;
            }

            for (Node nextNode : list.get(current.next)) {
                if (dist[nextNode.next] > current.cost + nextNode.cost) {
                    dist[nextNode.next] = current.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.next, dist[nextNode.next]));
                }
            }
        }
        return dist;
    }
}
