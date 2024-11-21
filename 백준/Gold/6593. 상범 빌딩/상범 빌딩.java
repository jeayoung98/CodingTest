import java.io.*;
import java.util.*;

public class Main {
    static int K, N, M;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] start;
    static int[] end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (K == 0 && N == 0 && M == 0) break;

            building = new char[K][N][M];
            start = new int[3];
            end = new int[3];

            for (int k = 0; k < K; k++) {
                for (int n = 0; n < N; n++) {
                    String row = br.readLine();
                    for (int m = 0; m < M; m++) {
                        building[k][n][m] = row.charAt(m);
                        if (building[k][n][m] == 'S') {
                            start = new int[]{k, n, m};
                        }
                        if (building[k][n][m] == 'E') {
                            end = new int[]{k, n, m};
                        }
                    }
                }
                br.readLine();
            }

            System.out.println(bfs(start[0], start[1], start[2]));
        }


    }

    public static String bfs(int z, int x, int y) {
        visited = new boolean[K][N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{z, x, y, 0});
        visited[z][x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cz = current[0];
            int cx = current[1];
            int cy = current[2];
            int cTime = current[3];


            if (cz == end[0] && cx == end[1] && cy == end[2]) {
                return String.format("Escaped in %d minute(s).",cTime);
            }
            
            for (int i = 0; i < 6; i++) {
                int nz = cz + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];


                if (nz >= 0 && nz < K && nx >= 0 && nx < N && ny >= 0 && ny < M &&
                        !visited[nz][nx][ny] && (building[nz][nx][ny] == '.' || building[nz][nx][ny] == 'E')) {
                    queue.add(new int[]{nz, nx, ny, cTime + 1});
                    visited[nz][nx][ny] = true;
                }
            }
        }

        return "Trapped!";
    }
}
