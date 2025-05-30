import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static Queue<int[]> queue;
    static int N, count = 0;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) bfs(i,j);
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            for (int i = 0; i < dx.length; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < N && arr[cx][cy] == 1 && !visited[cx][cy]) {
                    queue.add(new int[]{cx, cy});
                    visited[cx][cy] = true;
                    size++;
                }
            }
        }
        list.add(size);
        count++;
    }
}
