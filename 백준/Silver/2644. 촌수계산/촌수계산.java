import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,X,Y;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        X = Integer.parseInt(s[0]);
        Y = Integer.parseInt(s[1]);
        M = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            list[x].add(y);
            list[y].add(x);
        }
        visited = new boolean[N + 1];
        System.out.println(bfs(X));
    }

    public static int bfs(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int count = current[1];

            if (person == Y) {
                return count;
            }

            for (int i : list[person]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(new int[]{i, count + 1});
                }
            }
        }
        return -1;
    }
}
