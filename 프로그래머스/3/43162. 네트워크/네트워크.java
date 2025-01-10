import java.util.*;

class Solution {
    int answer = 0;
    boolean[][] visited;
    Queue<int[]> queue;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && computers[i][j] == 1){
                    bfs(computers, i, j,n);
                }
            }
        }
        return answer;
    }
    
    public void bfs(int[][] computers, int i , int j, int n){
        queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            visited[x][y] = true;
            add(computers, x, n);
            add(computers, y, n);
        }
        answer++;
    }
    
    public void add(int[][] computers, int k, int n){
        for(int p = 0; p < n; p++){
            if(computers[k][p] == 1 && !visited[k][p]){
                queue.add(new int[] {k,p});
            }
            if(computers[p][k] == 1 && !visited[p][k]){
                queue.add(new int[] {p,k});
            }
        }
    }
}