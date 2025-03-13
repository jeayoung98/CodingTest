import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] eggs;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            eggs[i][0] = Integer.parseInt(line[0]);
            eggs[i][1] = Integer.parseInt(line[1]);
        }

        backtrack(0);
        System.out.println(result);
    }

    static void backtrack(int depth) {
        if (depth == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i][0] <= 0) {
                    count++;
                }
            }
            result = Math.max(result, count);
            return;
        }

        if (eggs[depth][0] <= 0) {
            backtrack(depth + 1);
            return;
        }

        boolean visited = false;

        for (int j = 0; j < N; j++) {
            if (j == depth || eggs[j][0] <= 0) {
                continue;
            }

            visited = true;
            eggs[depth][0] -= eggs[j][1];
            eggs[j][0] -= eggs[depth][1];

            backtrack(depth + 1);

            eggs[depth][0] += eggs[j][1];
            eggs[j][0] += eggs[depth][1];
        }

        if (!visited) {
            backtrack(depth + 1);
        }
    }
}
