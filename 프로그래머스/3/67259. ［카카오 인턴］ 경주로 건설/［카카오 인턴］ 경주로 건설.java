import java.util.*;

class Solution {
    class Loc {
        int x, y, dir, cost;

        public Loc(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int[][][] cost;
    int[][] grid;
    int n;

    public int solution(int[][] board) {
        grid = board;
        n = board.length;

        cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        bfs();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n - 1][n - 1][i]);
        }

        return answer;
    }

    public void bfs() {
        Queue<Loc> queue = new ArrayDeque<>();
        queue.add(new Loc(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Loc current = queue.poll();

            int cx = current.x;
            int cy = current.y;
            int cd = current.dir;
            int cc = current.cost;

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (grid[nx][ny] == 1) {
                    continue;
                }

                int nc = cc;

                if (cd == -1) {
                    nc = cc + 100;
                }

                else if (cd == i) {
                    nc = cc + 100;
                }

                else {
                    nc = cc + 600;
                }

                if (cost[nx][ny][i] > nc) {
                    cost[nx][ny][i] = nc;

                    queue.add(new Loc(nx, ny, i, nc));
                }
            }
        }
    }
}