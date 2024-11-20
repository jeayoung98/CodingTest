import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static Queue<int[]> queue;
    static boolean[][] visited;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[] start = new int[2];
        boolean found = false;
        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    start = new int[]{i, j};
                    found = true;
                    break;
                }
            }
        }
        bfs(start[0],start[1]);

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    sb.append("0 ");
                } else if (visited[i][j]) {
                    sb.append(result[i][j]).append(" ");
                } else {
                    sb.append("-1 ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void bfs(int x, int y) {
        result = new int[N][M];
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited = new boolean[N][M];
        visited[x][y] = true;
        result[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0 && !visited[nx][ny]) {
                    result[nx][ny] = result[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
