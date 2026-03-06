import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[] arr;
    static int N, M, D, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        max = 0;
        grid = new int[N][M];
        arr = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    // 궁수 3명 조합 선택
    public static void dfs(int depth, int start) {
        if (depth == 3) {
            hunt();
            return;
        }

        for (int i = start; i < M; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void hunt() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = grid[i].clone();
        }

        int kill = 0;

        while (hasEnemy(copy)) {
            Set<String> targets = new HashSet<>();

            // 각 궁수가 공격할 적 선택
            for (int i = 0; i < 3; i++) {
                int current = arr[i];

                int md = Integer.MAX_VALUE;
                int tx = -1;
                int ty = -1;

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < M; y++) {
                        if (copy[x][y] == 0) continue;

                        int dist = Math.abs(N - x) + Math.abs(current - y);

                        if (dist > D) continue;

                        // 더 가까운 적
                        // 거리가 같으면 더 왼쪽 적
                        if (dist < md || (dist == md && y < ty)) {
                            md = dist;
                            tx = x;
                            ty = y;
                        }
                    }
                }

                if (tx != -1) {
                    targets.add(tx + "," + ty);
                }
            }

            // 동시에 제거
            for (String s : targets) {
                String[] parts = s.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                if (copy[x][y] == 1) {
                    copy[x][y] = 0;
                    kill++;
                }
            }

            // 아래로 이동
            move(copy);
        }

        max = Math.max(max, kill);
    }

    public static void move(int[][] copy) {
        for (int x = N - 1; x > 0; x--) {
            for (int y = 0; y < M; y++) {
                copy[x][y] = copy[x - 1][y];
            }
        }

        for (int y = 0; y < M; y++) {
            copy[0][y] = 0;
        }
    }

    public static boolean hasEnemy(int[][] copy) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (copy[x][y] == 1) return true;
            }
        }
        return false;
    }
}