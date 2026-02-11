import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        arr = new int[M];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int last = -1;
        for (int i = start; i <= N; i++) {
            if (last == nums[i]) continue;
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                last = nums[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}