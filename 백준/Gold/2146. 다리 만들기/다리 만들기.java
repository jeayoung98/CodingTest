import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static Queue<int[]> queue;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int num = 2;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, num);
                    num++;
                }
            }
        }

        int count = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    count = Math.min(bridge(i, j, arr[i][j]), count);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y, int num) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        arr[x][y] = num;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            for (int i = 0; i < dx.length; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < N && !visited[cx][cy] && arr[cx][cy] == 1) {
                    queue.add(new int[]{cx, cy});
                    visited[cx][cy] = true;
                    arr[cx][cy] = num;
                }
            }
        }
    }

    public static int bridge(int x, int y, int num) {
        queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int distance = current[2];

            for (int i = 0; i < dx.length; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                if (cx < 0 || cx >= N || cy < 0 || cy >= N || visited[cx][cy]) continue;

                if (arr[cx][cy] != 0 && arr[cx][cy] != num) {
                    return distance;
                }
                if (arr[cx][cy] == 0) {
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy, distance + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
