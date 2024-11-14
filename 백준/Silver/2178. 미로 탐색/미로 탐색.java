import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] arr;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - 48;
            }
        }

        System.out.println(bfs(N,M,arr));

    }

    public static int bfs(int N, int M,int[][] arr) {
        queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[][] distance = new int[N][M];
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
        return distance[N-1][M-1];
    }
}
