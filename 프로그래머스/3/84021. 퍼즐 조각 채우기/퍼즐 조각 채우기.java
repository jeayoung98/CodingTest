import java.util.*;

class Solution {
    int n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        List<List<int[]>> holes = find(game_board, 0);
        List<List<int[]>> puzzles = find(table, 1);

        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;

        for (List<int[]> hole : holes) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;
                if (hole.size() != puzzles.get(i).size()) continue;
                if (isSame(hole, puzzles.get(i))) {
                    used[i] = true;
                    answer += hole.size();
                    break;
                }
            }
        }

        return answer;
    }


    public List<List<int[]>> find(int[][] board, int target) {
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    result.add(bfs(board, visited, i, j, target));
                }
            }
        }
        return result;
    }


    public List<int[]> bfs(int[][] board, boolean[][] visited, int x, int y, int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> shape = new ArrayList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            shape.add(new int[]{cx, cy});

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != target) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return shape;
    }

    public boolean isSame(List<int[]> hole, List<int[]> puzzle) {
        if (hole.size() != puzzle.size()) {
            return false;
        }

        Set<String> set = new HashSet<>();

        for (int[] h : hole) {
            set.add(h[0] + "," + h[1]);
        }
        List<int[]> current = copy(puzzle);

        for (int i = 0; i < 4; i++) {
            for (int[] h : hole) {
                for (int[] c : current) {
                    int mx = h[0] - c[0];
                    int my = h[1] - c[1];

                    boolean same = true;

                    for (int[] arr : current) {
                        int nx = arr[0] + mx;
                        int ny = arr[1] + my;

                        if (!set.contains(nx + "," + ny)) {
                            same = false;
                            break;
                        }
                    }

                    if (same) return true;
                }
            }
            current = rotate(current);
        }

        return false;
    }

    public List<int[]> rotate(List<int[]> list) {
        List<int[]> result = new ArrayList<>();

        for (int[] point : list) {
            int x = point[0];
            int y = point[1];
            result.add(new int[]{y, -x});
        }

        return result;
    }


    public List<int[]> copy(List<int[]> list) {
        List<int[]> result = new ArrayList<>();

        for (int[] arr : list) {
            result.add(new int[]{arr[0], arr[1]});
        }

        return result;
    }
}