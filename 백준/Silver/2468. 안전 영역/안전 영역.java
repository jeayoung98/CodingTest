import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] range;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                set.add(Integer.valueOf(s[j]));
            }
        }
        int[] array = set.stream().mapToInt(Integer::intValue).toArray();
        range = new int[]{array[0], array[array.length - 1]};
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k <= range[1]; k++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > k) {
                        bfs(i, j, k);
                        count++;
                    }
                }
            }
            list.add(count);
        }
        System.out.println(list.stream().max((a,b)->a-b).orElse(0));
    }

    public static void bfs(int x, int y, int min) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] > min) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
