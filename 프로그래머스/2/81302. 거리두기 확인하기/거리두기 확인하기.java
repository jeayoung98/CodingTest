import java.util.*;

class Solution {
    class Applicant {
        int x, y, distance;
        public Applicant(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            String[][] room = new String[5][5];
            for (int j = 0; j < 5; j++) {
                String[] s = places[i][j].split("");
                for (int k = 0; k < 5; k++) {
                    room[j][k] = s[k];
                }
            }
            
            boolean isComplete = true;
            for (int x = 0; x < 5 && isComplete; x++) {
                for (int y = 0; y < 5 && isComplete; y++) {
                    if (room[x][y].equals("P")) {
                        if (!bfs(room, x, y)) {
                            isComplete = false;
                        }
                    }
                }
            }
            answer[i] = isComplete ? 1 : 0;
        }
        return answer;
    }
    
    public boolean bfs(String[][] room, int x, int y) {
        boolean[][] visited = new boolean[5][5];
        Queue<Applicant> queue = new LinkedList<>();
        queue.add(new Applicant(x, y, 0));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Applicant current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int dis = current.distance;
            
            if (dis > 0 && room[cx][cy].equals("P")) {
                return false;
            }
            
            if (dis < 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                    if (!visited[nx][ny] && !room[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new Applicant(nx, ny, dis + 1));
                    }
                }
            }
        }
        return true;
    }
}
