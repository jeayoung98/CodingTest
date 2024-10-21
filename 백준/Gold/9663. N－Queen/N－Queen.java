import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int num;
    static int[] a;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        num = array[0];
//        count = array[1];
        num = Integer.parseInt(bf.readLine());
        a = new int[num];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == num) {
            answer++;
            return;
        }
        for (int i = 0; i < num; i++) {
            a[depth] = i;
            if (isSafe(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean isSafe(int depth) {
        for (int i = 0; i < depth; i++) {
            if (a[i] == a[depth] || Math.abs(depth - i) == Math.abs(a[depth] - a[i])) {
                return false;
            }
        }
        return true;
    }
}
