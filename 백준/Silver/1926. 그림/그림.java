import java.util.*;

public class Main {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static int[][] arr;
    private static Queue<int[]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int size = bfs(i, j);
                    count++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    public static int bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            size++;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return size;
    }
}
