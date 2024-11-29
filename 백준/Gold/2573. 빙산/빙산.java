import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] arr;
    static int result;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        while (true) {
            int count = 0;
            int[] start = {-1, -1};
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > 0) {
                        count++;
                        if (start[0] == -1) {
                            start[0] = i;
                            start[1] = j;
                        }
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                break;
            }

            if (!bfs(start[0], start[1], count)) {
                System.out.println(result);
                break;
            }

            int[][] temp = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > 0) {
                        int countZero = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] <= 0) {
                                countZero++;
                            }
                        }
                        temp[i][j] = arr[i][j] - countZero;
                        if (temp[i][j] < 0) temp[i][j] = 0;
                    }
                }
            }
            arr = temp;
            result++;
        }
    }

    public static boolean bfs(int x, int y, int totalCount) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] > 0 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count == totalCount;
    }
}
