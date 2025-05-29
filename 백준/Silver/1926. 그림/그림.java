import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count, max;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = a[0];
        M = a[1];

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n").append(max);
        System.out.println(sb.toString());

    }

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int extent = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            for (int i = 0; i < dx.length; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < M && !visited[cx][cy] && arr[cx][cy] == 1) {
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy});
                    extent += 1;
                }
            }
        }
        max = Math.max(extent, max);
        count++;
    }
}
