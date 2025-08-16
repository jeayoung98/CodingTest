import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] arr;
    int maxSizeOfOneArea = 0;
    int numberOfArea = 0;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        arr = picture;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0 && !visited[i][j]){
                    bfs(i,j,m,n);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void bfs(int x, int y, int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        int currentMax = 1;
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int currentNum = arr[nx][ny];
            for(int i = 0; i < 4; i++){
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                
                if(cx < m && cy < n && cx >= 0 && cy >= 0 && arr[cx][cy] == currentNum && !visited[cx][cy]){
                    queue.add(new int[] {cx, cy});
                    visited[cx][cy] = true;
                    currentMax++;
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, currentMax);
        numberOfArea++;
    }
}