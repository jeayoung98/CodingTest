import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        for (int j = 0; j < testCount; j++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            arr = new int[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(s[2]);
            for (int i = 0; i < K; i++) {
                String[] str = br.readLine().split(" ");
                arr[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][k] == 1 && !visited[i][k]) {
                        bfs(i, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }



    }

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
