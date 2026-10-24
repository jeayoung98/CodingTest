
import java.util.*;

class Solution {
    int sx = 0;
    int sy = 0;

    int gx = 0;
    int gy = 0;

    boolean[][] visited;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    String[][] grid;

    public int solution(String[] board) {
        grid = new String[board.length][board[0].length()];
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = board[i].charAt(j) + "";

                if (grid[i][j].equals("R")) {
                    sx = i;
                    sy = j;
                }

                if (grid[i][j].equals("G")) {
                    gx = i;
                    gy = j;
                }
            }
        }

        return bfs();
    }

    public int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0});

        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int cx = current[0];
            int cy = current[1];
            int cc = current[2];

            if (cx == gx && cy == gy) return cc;

            for (int i = 0; i < 4; i++) {
                int nx = cx;
                int ny = cy;

                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    if (tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length || grid[tx][ty].equals("D")) {
                        break;
                    }

                    nx = tx;
                    ny = ty;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cc + 1});
                }
            }
        }

        return -1;
    }
}
