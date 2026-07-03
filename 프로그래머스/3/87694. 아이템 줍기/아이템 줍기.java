import java.util.*;

class Solution {
    static int[][] board = new int[102][102];
    static boolean[][] visited = new boolean[102][102];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    board[y][x] = 0;
                }
            }
        }

        int sx = characterX * 2;
        int sy = characterY * 2;
        int tx = itemX * 2;
        int ty = itemY * 2;

        return bfs(sx, sy, tx, ty) / 2;
    }

    private int bfs(int sx, int sy, int tx, int ty) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy, 0));
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == tx && current.y == ty) {
                return current.dist;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (board[ny][nx] != 1) {
                    continue;
                }

                visited[ny][nx] = true;
                queue.add(new Node(nx, ny, current.dist + 1));
            }
        }

        return -1;
    }
}