import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    static Set<String> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = array[0];
        M = array[1];
        result = new int[M];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    static void dfs(int idx, int depth) {
        StringBuilder sb1 = new StringBuilder();
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb1.append(result[i]).append(" ");
            }
            if (!visited.contains(sb1.toString())) {
                sb.append(sb1).append("\n");
                visited.add(sb1.toString());
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            result[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
