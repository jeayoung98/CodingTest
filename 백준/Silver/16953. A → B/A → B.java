import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    static long N, M;
    static Set<Long> visited;
    static Queue<long[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Long.parseLong(s[0]);
        M = Long.parseLong(s[1]);
        System.out.println(bfs());
    }

    public static long bfs() {
        queue = new LinkedList<>();
        visited = new HashSet<>();
        queue.add(new long[]{N, 1});
        visited.add(N);
        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long currentNum = current[0];
            long currentCount = current[1];
            if (currentNum == M) return currentCount;
            long x = currentNum * 2;
            long y = currentNum * 10 + 1;
            if (!visited.contains(x) && x <= M) {
                queue.add(new long[]{x, currentCount + 1});
                visited.add(x);
            }
            if (!visited.contains(y) && y <= M) {
                queue.add(new long[]{y, currentCount + 1});
                visited.add(y);
            }
        }
        return -1;
    }

}