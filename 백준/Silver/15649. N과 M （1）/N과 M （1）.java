import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int num;
    static int count;
    static int[] a;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        num = array[0];
        count = array[1];
        a = new int[count];
        visited = new boolean[num + 1];
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == count) {
            for (int i = 0; i < count; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                a[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
