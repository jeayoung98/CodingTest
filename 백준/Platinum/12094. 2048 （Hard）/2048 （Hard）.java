import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    public static void dfs(int depth, int[][] board) {
        int maxBlock = getMax(board);
        max = Math.max(max, maxBlock);

        if (depth == 10) return;

        int remain = 10 - depth;
        if ((maxBlock << remain) <= max) return;

        for (int dir = 0; dir < 4; dir++) {
            int[][] next = move(board, dir);
            if (isSame(board, next)) continue;
            dfs(depth + 1, next);
        }
    }

    public static int[][] move(int[][] board, int dir) {
        int[][] next = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];

            for (int j = 0; j < N; j++) {
                if (dir == 0) line[j] = board[i][j];
                else if (dir == 1) line[j] = board[i][N - 1 - j];
                else if (dir == 2) line[j] = board[j][i];
                else line[j] = board[N - 1 - j][i];
            }

            int[] merged = mergeLine(line);

            for (int j = 0; j < N; j++) {
                if (dir == 0) next[i][j] = merged[j];
                else if (dir == 1) next[i][N - 1 - j] = merged[j];
                else if (dir == 2) next[j][i] = merged[j];
                else next[N - 1 - j][i] = merged[j];
            }
        }

        return next;
    }

    public static int[] mergeLine(int[] line) {
        int[] temp = new int[N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (line[i] != 0) temp[idx++] = line[i];
        }

        int[] result = new int[N];
        int rIdx = 0;

        for (int i = 0; i < idx; i++) {
            if (i + 1 < idx && temp[i] == temp[i + 1]) {
                result[rIdx++] = temp[i] * 2;
                i++;
            } else {
                result[rIdx++] = temp[i];
            }
        }

        return result;
    }

    public static int getMax(int[][] board) {
        int cm = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cm = Math.max(cm, board[i][j]);
            }
        }
        return cm;
    }

    public static boolean isSame(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}