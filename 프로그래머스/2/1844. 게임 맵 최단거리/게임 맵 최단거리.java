import java.util.*;

class Solution {
    
    static int n, m;
    
    static int result = Integer.MAX_VALUE;
    
    static boolean[][] visited;
    
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(maps);
        
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        
        return result;
    }
    
    static void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int x = currentPosition[0];
            int y = currentPosition[1];
            int distance = currentPosition[2];
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m &&
                   !visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, distance + 1});
                    
                    if (nextX == n - 1 && nextY == m - 1) {
                        result = Math.min(result, distance + 1);
                    }
                }
            }
        }
    }
}