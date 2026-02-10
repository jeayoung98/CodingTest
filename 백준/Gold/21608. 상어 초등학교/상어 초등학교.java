import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] seat;
    static boolean[][] like;

    // 상, 하, 좌, 우 (순서 상관 없음)
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        M = N * N;

        seat = new int[N][N];
        like = new boolean[M + 1][M + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            for (int k = 0; k < 4; k++) {
                int v = Integer.parseInt(st.nextToken());
                like[s][v] = true;
            }

            place(s);
        }

        System.out.println(calcSatisfaction());
    }

    private static void place(int s) {
        int bestX = -1, bestY = -1;
        int bestLike = -1, bestBlank = -1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (seat[x][y] != 0) continue;

                int likeCnt = 0;
                int blankCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (!inRange(nx, ny)) continue;

                    int neighbor = seat[nx][ny];
                    if (neighbor == 0) blankCnt++;
                    else if (like[s][neighbor]) likeCnt++;
                }

                if (isBetter(x, y, likeCnt, blankCnt, bestX, bestY, bestLike, bestBlank)) {
                    bestX = x;
                    bestY = y;
                    bestLike = likeCnt;
                    bestBlank = blankCnt;
                }
            }
        }

        seat[bestX][bestY] = s;
    }

    // 규칙: (좋아하는 학생 인접 수 DESC) -> (빈칸 인접 수 DESC) -> (행 ASC) -> (열 ASC)
    private static boolean isBetter(int x, int y, int likeCnt, int blankCnt,
                                    int bestX, int bestY, int bestLike, int bestBlank) {
        if (likeCnt != bestLike) return likeCnt > bestLike;
        if (blankCnt != bestBlank) return blankCnt > bestBlank;
        if (bestX == -1) return true; // 최초 선택
        if (x != bestX) return x < bestX;
        return y < bestY;
    }

    private static int calcSatisfaction() {
        int score = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int s = seat[x][y];
                int likeCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (!inRange(nx, ny)) continue;

                    int neighbor = seat[nx][ny];
                    if (neighbor != 0 && like[s][neighbor]) likeCnt++;
                }

                // 0->0, 1->1, 2->10, 3->100, 4->1000
                if (likeCnt == 1) score += 1;
                else if (likeCnt == 2) score += 10;
                else if (likeCnt == 3) score += 100;
                else if (likeCnt == 4) score += 1000;
            }
        }

        return score;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
