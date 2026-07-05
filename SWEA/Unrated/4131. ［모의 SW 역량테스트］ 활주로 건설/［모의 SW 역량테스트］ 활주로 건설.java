import java.io.*;
import java.util.*;

public class Solution {

    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int j = 0; j < N; j++) {
                int[] line = new int[N];

                for (int k = 0; k < N; k++) {
                    line[k] = map[j][k];
                }

                if (canBuild(line)) {
                    answer++;
                }
            }

            // 세로 검사
            for (int j = 0; j < N; j++) {
                int[] line = new int[N];

                for (int k = 0; k < N; k++) {
                    line[k] = map[k][j];
                }

                if (canBuild(line)) {
                    answer++;
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static boolean canBuild(int[] line) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = line[i + 1] - line[i];

            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) >= 2) {
                return false;
            }

            // 오르막
            if (diff == 1) {
                int height = line[i];

                for (int j = i; j > i - X; j--) {
                    if (j < 0) {
                        return false;
                    }

                    if (line[j] != height) {
                        return false;
                    }

                    if (used[j]) {
                        return false;
                    }
                }

                for (int j = i; j > i - X; j--) {
                    used[j] = true;
                }
            }

            // 내리막
            else if (diff == -1) {
                int height = line[i + 1];

                for (int j = i + 1; j <= i + X; j++) {
                    if (j >= N) {
                        return false;
                    }

                    if (line[j] != height) {
                        return false;
                    }

                    if (used[j]) {
                        return false;
                    }
                }

                for (int j = i + 1; j <= i + X; j++) {
                    used[j] = true;
                }
            }
        }

        return true;
    }
}