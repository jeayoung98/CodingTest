import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static Set<List<Integer>> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = array[0];
        M = array[1];
        arr = new int[M];
        visited = new boolean[N + 1];
        set = new HashSet<>();
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                a.add(arr[i]);
            }
            a.sort((x,y)->x-y);
            if (!set.contains(a)) {
                for (int i = 0; i < M; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

            set.add(a);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}