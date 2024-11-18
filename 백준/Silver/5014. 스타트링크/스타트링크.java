import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/*
F -> 총 층수
S -> 현재 위치
G -> 목표 위치
U -> 위로 몇칸
D -> 아래로 몇칸
 */
public class Main {
    static int F;
    static int S;
    static int G;
    static int[] move;
    static Queue<int[]> queue;
    static Set<Integer> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        F = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        G = Integer.parseInt(s[2]);
        move = new int[]{Integer.parseInt(s[3]), -Integer.parseInt(s[4])};
        int bfs = bfs();
        if (bfs == -1) System.out.println("use the stairs");
        else System.out.println(bfs);
    }

    public static int bfs() {
        queue = new LinkedList<>();
        visited = new HashSet<>();
        queue.add(new int[]{S, 0});
        visited.add(S);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int floor = current[0];
            int count = current[1];
            if(floor == G) return count;
            for (int i : move) {
                int n = floor + i;
                if (n > 0 && n <= F && !visited.contains(n)) {
                    queue.add(new int[]{n, count + 1});
                    visited.add((n));
                }
            }
        }
        return -1;
    }
}
