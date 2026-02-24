import java.io.*;
import java.util.*;

public class Main {

    static int size = 4;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = { 0, -1,-1,-1, 0, 1, 1,  1};

    static int answer = 0;

    static class Fish {
        int x, y, dir;
        boolean alive;

        Fish(int x, int y, int dir, boolean alive) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = alive;
        }

        Fish copy() {
            return new Fish(x, y, dir, alive);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[size][size];
        Fish[] fishes = new Fish[17];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = num;
                fishes[num] = new Fish(i, j, dir, true);
            }
        }

        // 상어가 (0,0) 고기 먹음
        int first = board[0][0];
        int sharkDir = fishes[first].dir;
        int sum = first;

        fishes[first].alive = false;
        board[0][0] = 0;

        dfs(board, fishes, 0, 0, sharkDir, sum);

        System.out.println(answer);
    }

    static void dfs(int[][] board, Fish[] fishes, int sharkR, int sharkC, int sharkDir, int sum) {
        answer = Math.max(answer, sum);

        // 물고기 이동
        moveAllFish(board, fishes, sharkR, sharkC);

        // 상어 이동 가능한 칸
        for (int step = 1; step < size; step++) {
            int nr = sharkR + dx[sharkDir] * step;
            int nc = sharkC + dy[sharkDir] * step;

            // 범위 처리
            if (!inRange(nr, nc)) break;
            // 빈칸 처리
            if (board[nr][nc] == 0) continue;

            // 상태 복사
            int[][] nextBoard = copyBoard(board);
            Fish[] nextFishes = copyFishes(fishes);

            int fishNum = nextBoard[nr][nc];
            int nextSharkDir = nextFishes[fishNum].dir;

            // 상어가 물고기 먹기
            nextFishes[fishNum].alive = false;
            nextBoard[nr][nc] = 0;

            dfs(nextBoard, nextFishes, nr, nc, nextSharkDir, sum + fishNum);
        }
    }

    static void moveAllFish(int[][] board, Fish[] fishes, int sharkX, int sharkY) {
        for (int i = 1; i <= 16; i++) {
            Fish fish = fishes[i];
            if (fish == null || !fish.alive) continue;

            for (int j = 0; j < 8; j++) {
                int nd = (fish.dir + j) % 8;
                int nx = fish.x + dx[nd];
                int ny = fish.y + dy[nd];

                // 이동 불가
                if (!inRange(nx, ny)) continue;
                if (nx == sharkX && ny == sharkY) continue;

                // 방향 갱신
                fish.dir = nd;

                if (board[nx][ny] == 0) {
                    // 빈칸 이동
                    board[fish.x][fish.y] = 0;
                    board[nx][ny] = i;
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    // 자리 교환
                    int otherNum = board[nx][ny];
                    Fish other = fishes[otherNum];

                    int cr = fish.x;
                    int cc = fish.y;

                    // 보드 swap
                    board[cr][cc] = otherNum;
                    board[nx][ny] = i;

                    // 위치 swap
                    fish.x = nx;
                    fish.y = ny;
                    other.x = cr;
                    other.y = cc;
                }
                break;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, size);
        }
        return copy;
    }

    static Fish[] copyFishes(Fish[] fishes) {
        Fish[] copy = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            if (fishes[i] != null) {
                copy[i] = fishes[i].copy();
            }
        }
        return copy;
    }
}