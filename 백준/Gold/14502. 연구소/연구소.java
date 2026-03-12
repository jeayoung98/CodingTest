import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max = 0;
    static int[][] laboratory;
    static int[] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<int[]> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        laboratory = new int[N][M];
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int current = Integer.parseInt(st.nextToken());
                if (current == 2) virus.add(new int[]{i, j});
                laboratory[i][j] = current;
            }
        }

        arr = new int[3];
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int depth, int start) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (laboratory[x][y] == 0) {
                arr[depth] = i;
                dfs(depth + 1, i + 1);
            }
        }
    }

    public static void bfs() {
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = laboratory[i].clone();
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int x = num / M;
            int y = num % M;
            grid[x][y] = 1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] v : virus) {
            queue.add(new int[]{v[0], v[1]});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == 0) {
                    grid[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) count++;
            }
        }

        max = Math.max(count, max);
    }
}