import java.util.*;

class Solution {
    int typeCount = 0;
    int answer = Integer.MAX_VALUE;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(int[][] board, int r, int c) {
        boolean[] cards = new boolean[7];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j] != 0) cards[board[i][j]] = true;
            }
        }
        
        for(boolean card : cards){
            if(card) typeCount++;
        }
        
        dfs(board, r, c, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[][] board, int x, int y, int removeC, int moveC){
        if(removeC == typeCount){
            answer = Math.min(answer, moveC);
            return;
        }
        
        if(moveC >= answer) return;
        
        for(int i = 1; i <= 6; i++){
            List<int[]> list = find(board, i);
            
            if(list.isEmpty()) continue;
            
            int[] start = list.get(0);
            int[] end = list.get(1);
            
            int sd = bfs(board, x, y, start[0], start[1]);
            int st = bfs(board, start[0], start[1], end[0], end[1]);
            
            board[start[0]][start[1]] = 0;
            board[end[0]][end[1]] = 0;
            
            dfs(board, end[0], end[1], removeC + 1, moveC + sd + st + 2);
            
            board[start[0]][start[1]] = i;
            board[end[0]][end[1]] = i;
            
            int ed = bfs(board, x, y, end[0], end[1]);
            int et = bfs(board, end[0], end[1], start[0], start[1]);
            
            board[start[0]][start[1]] = 0;
            board[end[0]][end[1]] = 0;
            
            dfs(board, start[0], start[1], removeC + 1, moveC + ed + et + 2);
            
            board[start[0]][start[1]] = i;
            board[end[0]][end[1]] = i;
            
        }
    }
    
    public List<int[]> find(int[][] board, int target){
        List<int[]> list = new ArrayList<>(2);
        
        for(int i = 0; i < 4; i++){
            for(int j =0; j < 4; j++){
                if(board[i][j] == target) list.add(new int[]{i,j});
            }
        }
        
        return list;
    }
    
    public int bfs(int[][] board, int sx, int sy, int tx, int ty){
        if (sx == tx && sy == ty) return 0;
        boolean[][] visited = new boolean[4][4];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            int d = current[2];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(isValid(nx, ny) && !visited[nx][ny]){
                    if(nx == tx && ny == ty) return d + 1;
                    
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, d + 1});
                }
                
                int[] ctrl = ctrlMove(board, x, y, i);
                nx = ctrl[0];
                ny = ctrl[1];
                
                if(!visited[nx][ny]){
                    if(nx == tx && ny == ty) return d + 1;
                    
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, d + 1});
                }
            }      
        }
        return -1;
    }
    
    public boolean isValid(int x, int y){
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
    
    public int[] ctrlMove(int[][] board, int x, int y, int dir){
        int nx = x;
        int ny = y;
        while(true){
            int cx = nx + dx[dir];
            int cy = ny + dy[dir];
            
            if(!isValid(cx, cy)){
                return new int[]{nx, ny};
            }
            
            nx = cx;
            ny = cy;
            
            if(board[nx][ny] != 0) return new int[]{nx, ny};
        }
    }
}