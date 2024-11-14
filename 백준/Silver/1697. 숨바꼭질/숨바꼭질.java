import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> visited;
    static Queue<int[]> queue; // 위치와 시간을 함께 저장
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        System.out.println(bfs(N));
    }

    public static int bfs(int N) {
        queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited = new HashSet<>();
        visited.add(N);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == M) return time; 

            int[] moves = move(position);
            for (int nx : moves) {
                if (nx >= 0 && nx <= 100000 && !visited.contains(nx)) {
                    queue.add(new int[]{nx, time + 1});
                    visited.add(nx);
                }
            }
        }
        return -1;
    }

    public static int[] move(int x) {
        int a = x + 1;
        int b = x - 1;
        int c = x * 2;
        return new int[]{a, b, c};
    }
}
