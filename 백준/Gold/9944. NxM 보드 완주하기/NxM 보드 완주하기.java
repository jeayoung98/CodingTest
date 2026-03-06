import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int min;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int idx = 1;
        String line;

        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new char[N][M];
            count = 0;

            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '.') count++;
                }
            }

            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '.') {
                        visited = new boolean[N][M];
                        visited[i][j] = true;
                        dfs(i, j, 1, 0);
                    }
                }
            }

            sb.append("Case ").append(idx++).append(": ").append(min == Integer.MAX_VALUE ? -1 : min).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y, int visitedCount, int moveCount) {
        if (visitedCount == count) {
            min = Math.min(min, moveCount);
            return;
        }

        if (moveCount >= min) return;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!isValid(nx, ny)) continue;

            List<int[]> path = new ArrayList<>();

            while (isValid(nx, ny)) {
                visited[nx][ny] = true;
                path.add(new int[]{nx, ny});
                nx += dx[dir];
                ny += dy[dir];
            }

            int lastX = nx - dx[dir];
            int lastY = ny - dy[dir];

            dfs(lastX, lastY, visitedCount + path.size(), moveCount + 1);

            for (int[] p : path) {
                visited[p[0]][p[1]] = false;
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && board[x][y] == '.' && !visited[x][y];
    }
}