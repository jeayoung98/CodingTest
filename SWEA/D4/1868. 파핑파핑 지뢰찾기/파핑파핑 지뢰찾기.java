import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            int N = Integer.parseInt(br.readLine());
            String[][] arr = new String[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine().split("");
            }

            int[][] mineArr = new int[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(arr[x][y].equals(".")) mineArr[x][y] = countMine(arr,x,y);
                    else mineArr[x][y] = -1;
                }
            }

            int result = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(!visited[x][y] && mineArr[x][y] == 0) {
                        if(bfs(mineArr, visited,x,y)) result++;
                    }
                }
            }

            for (int q = 0; q < N; q++) {
                for (int p = 0; p < N; p++) {
                    if (!visited[q][p] && mineArr[q][p] != -1) {
                        visited[q][p] = true;
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }

    public static int countMine(String[][] arr, int x, int y) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < len && ny >= 0 && ny < len && arr[nx][ny].equals("*")) count++;
        }

        return count;
    }

    public static boolean bfs(int[][] mineArr,boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int len = mineArr.length;
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int cx = current[0];
                int cy = current[1];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < len && ny >= 0 && ny < len && !visited[nx][ny] && mineArr[nx][ny] != -1) {
                    visited[nx][ny] = true;
                    if (mineArr[nx][ny] == 0){
                        queue.add(new int[]{nx, ny});
                    }
                    count++;
                }
            }

        }

        return count >= 1;
    }
}