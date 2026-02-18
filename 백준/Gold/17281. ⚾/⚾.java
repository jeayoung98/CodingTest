import java.io.*;
import java.util.*;

public class Main {
    static int[][] expectation;
    static boolean[] visited = new boolean[10];
    static int[] arr = new int[10];
    static int N, maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        expectation = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                expectation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[4] = 1;
        visited[1] = true;

        dfs(1);

        System.out.println(maxScore);
    }

    static void dfs(int depth) {
        if (depth == 10) {
            maxScore = Math.max(maxScore, playBall());
            return;
        }

        if (depth == 4) {
            dfs(depth + 1);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int playBall() {
        int score = 0;
        int idx = 1;
        boolean[] base = new boolean[4];

        for (int i = 1; i <= N; i++) {
            int out = 0;
            base[1] = base[2] = base[3] = false;

            while (out < 3) {
                int player = arr[idx];
                int result = expectation[i][player];

                if (result == 0) {
                    out++;
                } else if (result == 4) {
                    if (base[1]) score++;
                    if (base[2]) score++;
                    if (base[3]) score++;
                    score++;
                    base[1] = base[2] = base[3] = false;
                } else {

                    for (int j = 3; j >= 1; j--) {
                        if (!base[j]) continue;
                        int nb = j + result;
                        if (nb >= 4) score++;
                        else base[nb] = true;
                        base[j] = false;
                    }
                    base[result] = true;
                }

                idx++;
                if (idx == 10) idx = 1;
            }
        }
        return score;
    }
}
