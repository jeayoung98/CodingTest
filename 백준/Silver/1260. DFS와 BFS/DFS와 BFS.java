import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,K;
    static List<Integer>[] list;
    static Queue<Integer> queue;
    static boolean[] visitedBfs;
    static boolean[] visitedDfs;
    static StringBuilder sbDfs = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
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
            list[x].sort((a, b) -> a - b);
            list[y].sort((a, b) -> a - b);
        }
        visitedDfs = new boolean[N + 1];
        dfs(K,  1);
        System.out.println(sbDfs);
        bfs(K);
    }

    public static void bfs(int start) {
        queue = new LinkedList<>();
        queue.add(start);
        visitedBfs = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        visitedBfs[start] = true;
        sb.append(start).append(" ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int x : list[current]) {
                if (!visitedBfs[x]) {
                    visitedBfs[x] = true;
                    queue.add(x);
                    sb.append(x).append(" ");
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int current,int depth) {
        visitedDfs[current] = true;

        sbDfs.append(current).append(" ");

        for (int x : list[current]) {
            if (!visitedDfs[x]) {
                dfs(x,depth+1);
            }
        }
    }
}