import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String[] s1 = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(arr);
        visited = new boolean[N];
        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int last = -1;
        for (int i = 0; i < N; i++) {
            if (last == arr[i]) continue;
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                last = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
