import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] board;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static Map<String, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.setLength(0);
                dfs(i, j, 1, sb);
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < K; i++) {
            String target = br.readLine();
            out.append(countMap.getOrDefault(target, 0)).append('\n');
        }

        System.out.print(out);
    }

    static void dfs(int x, int y, int depth, StringBuilder sb) {
        sb.append(board[x][y]);

        String cur = sb.toString();
        countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);

        if (depth == 5) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        for (int d = 0; d < 8; d++) {
            int nx = (x + dx[d] + N) % N;
            int ny = (y + dy[d] + M) % M;
            dfs(nx, ny, depth + 1, sb);
        }

        sb.deleteCharAt(sb.length() - 1);
    }
}