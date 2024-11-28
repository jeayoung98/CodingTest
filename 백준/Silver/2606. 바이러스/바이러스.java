import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static List<Integer>[] list;
    static Queue<Integer> queue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            list[x].add(y);
            list[y].add(x);
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int count = 0;
        queue = new LinkedList<>();
        visited = new boolean[N + 1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int x : list[current]) {
                if (!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                    count++;
                }
            }
        }
        return count;
    }
}