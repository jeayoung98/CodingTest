import java.io.*;
import java.util.*;

public class Main {
    static class Bishop{
        int x, y;

        public Bishop(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] board;
    static boolean[] upper;
    static boolean[] bottom;
    static int bMax = 0;
    static int wMax = 0;

    static List<Bishop> black = new ArrayList<>();
    static List<Bishop> white = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        upper = new boolean[2 * N];
        bottom = new boolean[2 * N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    if ((i + j) % 2 == 0) black.add(new Bishop(i,j));
                    else white.add(new Bishop(i,j));
                }
            }
        }

        dfs(black, 0, 0, true);
        dfs(white, 0, 0, false);

        System.out.println(bMax + wMax);
    }

    public static void dfs(List<Bishop> list, int depth, int count, boolean isBlack) {

        if (depth == list.size()) {
            if (isBlack) bMax = Math.max(bMax, count);
            else wMax = Math.max(wMax, count);
            return;
        }

        int x = list.get(depth).x;
        int y = list.get(depth).y;

        if (!upper[x + y] && !bottom[x - y + N]) {

            upper[x + y] = true;
            bottom[x - y + N] = true;

            dfs(list, depth + 1, count + 1, isBlack);

            upper[x + y] = false;
            bottom[x - y + N] = false;
        }

        dfs(list, depth + 1, count, isBlack);
    }
}