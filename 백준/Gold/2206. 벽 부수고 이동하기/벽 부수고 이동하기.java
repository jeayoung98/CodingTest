import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && current.breakWall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new Node(nx, ny, current.distance + 1, 1));
                }

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && !visited[nx][ny][current.breakWall]) {
                    visited[nx][ny][current.breakWall] = true;
                    queue.add(new Node(nx, ny, current.distance + 1, current.breakWall));
                }
            }
        }

        return -1;
    }

    static class Node {
        int x, y;
        int distance;
        int breakWall;

        public Node(int x, int y, int distance, int breakWall) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.breakWall = breakWall;
        }
    }
}
