import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);

        System.out.println(count);
    }

    static void dfs(int index, int sum, int depth) {
        if(index == N) {
            if(depth > 0 && sum == M) {
                count++;
            }
            return;
        }

        dfs(index + 1, sum, depth);

        dfs(index + 1, sum + arr[index], depth + 1);
    }
}
