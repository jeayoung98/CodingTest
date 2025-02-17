import java.util.*;

class Solution {
    boolean[][] visited;
    String[][] arr;
    int startX, startY;
    int goalX, goalY;

    public int solution(String[] board) {

        visited = new boolean[board.length][board[0].length()];
        arr = new String[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            String[] s = board[i].split("");
            for (int j = 0; j < board[0].length(); j++) {
                if (s[j].equals("R")) {
                    startX = i;
                    startY = j;
                } else if (s[j].equals("G")) {
                    goalX = i;
                    goalY = j;
                }
                arr[i][j] = s[j];
            }
        }

        return bfs();
        
    }
    
    public int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if (x == goalX && y == goalY) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while (true) {
                    int cx = nx + dx[i];
                    int cy = ny + dy[i];

                    if (cx < 0 || cx >= arr.length || cy < 0 || cy >= arr[0].length) {
                        break;
                    }
                    if (arr[cx][cy].equals("D")) {
                        break;
                    }

                    nx = cx;
                    ny = cy;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1;
    }
}
