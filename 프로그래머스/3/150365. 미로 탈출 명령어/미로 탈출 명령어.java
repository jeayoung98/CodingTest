import java.util.*;

class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = getDist(x, y, r, c);

        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }

        StringBuilder path = new StringBuilder();

        int cx = x;
        int cy = y;

        for (int i = 0; i < k; i++) {
            int cm = k - i - 1;

            for (int j = 0; j < 4; j++) {
                int nx = cx + dx[j];
                int ny = cy + dy[j];

                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }

                int cd = getDist(nx, ny, r, c);

                // 남은 이동 횟수로 도착 가능한지
                if (cd <= cm && (cm - cd) % 2 == 0) {

                    path.append(dir[j]);
                    cx = nx;
                    cy = ny;
                    break;
                }
            }
        }

        return path.toString();
    }

    private int getDist(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}