import java.util.*;

class Solution {
     public static class Node {
        int x, y, distance;
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        String[][] arr = new String[n][m];
        int startX = 0, startY = 0, leverX = 0, leverY = 0, goalX = 0, goalY = 0;
        
        for (int i = 0; i < n; i++) {
            String[] str = maps[i].split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = str[j];
                if (arr[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                } else if (arr[i][j].equals("L")) {
                    leverX = i;
                    leverY = j;
                } else if (arr[i][j].equals("E")) {
                    goalX = i;
                    goalY = j;
                }
            }
        }
        
        int lever = bfs(arr, startX, startY, "L");
        if (lever == -1) return -1;
        
        int goal = bfs(arr, leverX, leverY, "E");
        if (goal == -1) return -1;
        
        return lever + goal;
    }
    
    public int bfs(String[][] arr, int x, int y, String target) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (arr[current.x][current.y].equals(target)) {
                return current.distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && !arr[nx][ny].equals("X")) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, current.distance + 1));
                }
            }
        }
        return -1;
    }
}
