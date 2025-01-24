import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    int[][] arr;
    int[] sizes;
    int count = 1;
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        arr = new int[n][m];
        
        sizes = new int[n * m + 1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && arr[i][j] == 0) {
                    bfs(i, j, land, n, m);
                    count++;
                }
            }
        }
        
        int[] sums = new int[m];
        int[] marker = new int[count + 1];
        
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                if(arr[i][j] != 0) {
                    int c = arr[i][j];
                    if(marker[c] != j + 1) {
                        sums[j] += sizes[c];
                        marker[c] = j + 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer,sums[i]);
        }
        
        return answer;
    }
    
    public void bfs(int x, int y, int[][] land, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = count;
        int size = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && arr[nx][ny] == 0) {
                    arr[nx][ny] = count;
                    size++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        sizes[count] = size;
    }
}
