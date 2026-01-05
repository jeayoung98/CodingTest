import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] head;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        head = new int[N + 1];
        visited = new boolean[N + 1];
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(head[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        head[1] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : list[current]) {
                if (!visited[i]) {
                    visited[i] = true;
                    head[i] = current;
                    queue.add(i);
                }
            }
        }
    }
}
