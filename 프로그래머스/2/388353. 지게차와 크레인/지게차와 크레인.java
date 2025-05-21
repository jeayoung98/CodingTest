import java.util.*;

class Solution {
    int answer;
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        String[][] arr = new String[n][m];
        answer = n * m;

        for (int i = 0; i < n; i++) {
            String line = storage[i];
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) + "";
            }
        }

        for (String request : requests) {
            if (request.length() == 2) {
                crane(arr, request.charAt(0) + "");
            } else {
                lift(arr, request.charAt(0) + "");
            }
        }

        return answer;
    }

    public void crane(String[][] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (target.equals(arr[i][j])) {
                    arr[i][j] = "0";
                    answer--;
                }
            }
        }
    }

    public void lift(String[][] arr, String target) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            if (!visited[i][0]) {
                queue.add(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (!visited[i][m - 1]) {
                queue.add(new int[]{i, m - 1});
                visited[i][m - 1] = true;
            }
        }

        for (int j = 0; j < m; j++) {
            if (!visited[0][j]) {
                queue.add(new int[]{0, j});
                visited[0][j] = true;
            }
            if (!visited[n - 1][j]) {
                queue.add(new int[]{n - 1, j});
                visited[n - 1][j] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (arr[x][y].equals(target)) {
                arr[x][y] = "0";
                answer--;
            }

            else if(arr[x][y].equals("0")){
                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
        }
            
        }
    }
}
