class Solution {
    int n, m;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;

        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]); 
    }

    public int dfs(int[][] board, int ax, int ay, int bx, int by) {
        if (board[ax][ay] == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < 4; i++) {
            int nx = ax + dx[i];
            int ny = ay + dy[i];

            if (!canMove(board, nx, ny)) {
                continue;
            }

            board[ax][ay] = 0;

            int nextCount = dfs(board, bx, by, nx, ny) + 1;

            board[ax][ay] = 1;


            if (result % 2 == 0 && nextCount % 2 == 1) {
                // 승리 경로를 발견
                result = nextCount;
            } else if (result % 2 == 0 && nextCount % 2 == 0) {
                // 최대한 오래 버팀
                result = Math.max(result, nextCount);
            } else if (result % 2 == 1 && nextCount % 2 == 1) {
                // 가장 빨리 이기는 경로
                result = Math.min(result, nextCount);
            }
        }

        return result;
    }

    public boolean canMove(int[][] board, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 1;
    }
}