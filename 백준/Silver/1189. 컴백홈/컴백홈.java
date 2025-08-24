import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    static int result;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = a[0];
        M = a[1];
        K = a[2];

        arr = new String[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
        
        visited[N - 1][0] = true;
        dfs(N - 1, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int depth) {
        if (x == 0 && y == M - 1) {
            if (depth == K) result++;
            return;
        }

        if (depth >= K) return;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cx >= N || cy < 0 || cy >= M || visited[cx][cy] || arr[cx][cy].equals("T")) continue;

            visited[cx][cy] = true;
            dfs(cx, cy, depth + 1);
            visited[cx][cy] = false;
        }
    }
}
