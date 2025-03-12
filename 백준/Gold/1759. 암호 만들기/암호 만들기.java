import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static String[] arr;
    static String[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = br.readLine().split(" ");
        result = new String[N];
        Arrays.sort(arr);

        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int start, int depth) {
        if (depth == N) {
            if (isValid()) {
                for (int i = 0; i < N; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < M; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static boolean isValid() {
        int count = 0;
        for (String current : result) {
            if (current.equals("i") || current.equals("e") || current.equals("o") || current.equals("a") || current.equals("u")) {
                count++;
            }
        }
        return count >= 1 && count <= N - 2;
    }
}