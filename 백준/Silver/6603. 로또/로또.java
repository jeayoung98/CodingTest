import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = -1;
        while (N != 0) {
            sb = new StringBuilder();
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = array[0];
            arr = Arrays.copyOfRange(array, 1, array.length);
            result = new int[6];
            visited = new boolean[N];
            dfs(0,0);

            System.out.println(sb.toString());
        }

    }

    public static void dfs(int index, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i < arr.length; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

}
