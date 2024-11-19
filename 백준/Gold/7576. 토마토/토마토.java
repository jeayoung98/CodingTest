import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] arr;
    static int[][] days;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        days = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                days[i][j] = -1;
                if (arr[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    days[i][j] = 0;
                }
            }
        }

        bfs();
        int result = 0;
        boolean isPossible = true;

        for (int i = 0; i < N && isPossible; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    isPossible = false;
                    break;
                }
                result = Math.max(result, days[i][j]);
            }
        }

        System.out.println(isPossible ? result : -1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        days[nx][ny] = days[x][y] + 1;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
