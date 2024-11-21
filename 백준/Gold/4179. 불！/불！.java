import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] fire;
    static int[][] result;
    static Queue<int[]> queue;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fire = new int[N][M];
        result = new int[N][M];
        int time = Integer.MAX_VALUE;
        List<int[]> fireIndex = new ArrayList<>();
        int[] resultIndex = new int[2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (s[j].equals("F")) {
                    fire[i][j] = 1;
                    fireIndex.add(new int[]{i,j});
                }

                if (s[j].equals("J")) {
                    result[i][j] = 1;
                    resultIndex = new int[]{i, j};
                }

                if (s[j].equals("#")) {
                    fire[i][j] = -1;
                    result[i][j] = -1;
                }
            }
        }
        for (int[] a : fireIndex) {
            bfs(a[0],a[1],fire);
        }

        bfs(resultIndex[0],resultIndex[1],result);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                    if ((fire[i][j] > result[i][j] && result[i][j] != 0) || (fire[i][j] == 0 && result[i][j] != 0)) {
                        time = Math.min(time, result[i][j]);
                    }
                }
            }
        }
        if (time == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        }
        else System.out.println(time);
    }

    public static void bfs(int x, int y,int[][] arr) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited = new boolean[N][M];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] != -1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[cx][cy] + 1;
                    } else arr[nx][ny] = Math.min(arr[nx][ny], arr[cx][cy] + 1);

                }
            }
        }
    }
}
