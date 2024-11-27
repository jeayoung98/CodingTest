import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static class Node {
        int loc;
        int time;

        public Node(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }

    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        if (N == M) {
            System.out.println(0);
            return;
        }

        int result = bfs(N);
        System.out.println(result);
    }

    public static int bfs(int start) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.addFirst(new Node(start, 0));
        visited = new boolean[100001];
        visited[start] = true;

        while (!dq.isEmpty()) {
            Node current = dq.pollFirst();
            int loc = current.loc;
            int time = current.time;

            int teleport = loc * 2;
            if (teleport <= 100000 && !visited[teleport]) {
                if (teleport == M) {
                    return time;
                }
                dq.addFirst(new Node(teleport, time));
                visited[teleport] = true;
            }

            int walk2 = loc - 1;
            if (walk2 >= 0 && !visited[walk2]) {
                if (walk2 == M) {
                    return time + 1;
                }
                dq.addLast(new Node(walk2, time + 1));
                visited[walk2] = true;
            }

            int walk1 = loc + 1;
            if (walk1 <= 100000 && !visited[walk1]) {
                if (walk1 == M) {
                    return time + 1;
                }
                dq.addLast(new Node(walk1, time + 1));
                visited[walk1] = true;
            }
        }

        return -1;
    }
}
