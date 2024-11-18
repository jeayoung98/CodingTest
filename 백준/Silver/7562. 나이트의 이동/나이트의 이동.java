import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> visited;
    static Queue<int[]> queue;
    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] start = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
            String[] g = br.readLine().split(" ");
            int[] goal = new int[]{Integer.parseInt(g[0]), Integer.parseInt(g[1])};
            System.out.println(bfs(start, goal));
        }
    }

    public static int bfs(int[] start, int[] goal) {
        queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited = new HashSet<>();
        visited.add(start[0] + "," + start[1]);
        int count = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int[] current = new int[]{poll[0], poll[1]};
            count = poll[2];
            if (Arrays.equals(current, goal)) break;
            for (int i = 0; i < dx.length; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < M && !visited.contains(nx + "," + ny)) {
                    queue.add(new int[]{nx, ny, count + 1});
                    visited.add(nx + "," + ny);
                }
            }
        }
        return count;
    }
}
