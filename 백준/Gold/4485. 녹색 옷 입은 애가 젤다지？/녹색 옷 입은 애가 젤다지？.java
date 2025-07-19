import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int count = 1;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Node {
        int x, y, score;

        public Node(int x, int y, int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int result = dijkstra(N);
            System.out.println("Problem " + count + ": " + result);
            count++;
        }
    }

    public static int dijkstra(int N) {
        dist = new int[N][N];
        visited = new boolean[N][N];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.score, b.score));
        queue.add(new Node(0, 0, arr[0][0]));
        dist[0][0] = arr[0][0];

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int currentScore = dist[x][y] + arr[nx][ny];
                    if (currentScore < dist[nx][ny]) {
                        dist[nx][ny] = currentScore;
                        queue.add(new Node(nx, ny, currentScore));
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}
