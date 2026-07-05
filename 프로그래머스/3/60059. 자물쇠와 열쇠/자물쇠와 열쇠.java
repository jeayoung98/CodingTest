import java.util.*;

class Solution {
        // key를 회전 (4번) * 모든 경우 순회 (n * n)
        // 만약 lock이 될 수 있는 경우라면 갯수가 같은지 확인
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        if (list.isEmpty()) return true;

        int[][] cKey = key;

        for (int i = 0; i < 4; i++) {
            List<int[]> ones = getOnes(cKey);

            for (int[] one : ones) {
                for (int[] hole : list) {
                    int dx = hole[0] - one[0];
                    int dy = hole[1] - one[1];

                    if (canOpen(cKey, lock, list.size(), dx, dy)) {
                        return true;
                    }
                }
            }

            cKey = rotate(cKey);
        }

        return false;
    }

    public boolean canOpen(int[][] key, int[][] lock, int holeCount, int dx, int dy) {
        int n = lock.length;
        int m = key.length;

        boolean[][] filled = new boolean[n][n];
        int filledCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (key[i][j] == 0) continue;

                int nx = i + dx;
                int ny = j + dy;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (lock[nx][ny] == 1) {
                    return false;
                }

                if (!filled[nx][ny]) {
                    filled[nx][ny] = true;
                    filledCount++;
                }
            }
        }

        return filledCount == holeCount;
    }

    public List<int[]> getOnes(int[][] key) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        return list;
    }

    public int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }

        return result;
    }
}