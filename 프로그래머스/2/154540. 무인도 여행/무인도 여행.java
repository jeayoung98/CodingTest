import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        String[][] arr = new String[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            String[] s = maps[i].split("");
            for(int j = 0; j < s.length; j++){
                arr[i][j] = s[j];
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(!arr[i][j].equals("X")){
                    list.add(bfs(arr, i, j));
                    count++;
                }
            }
        }
        int[] answer = new int[count];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return (answer.length == 0) ? new int[]{-1} : answer;
    }
    
    public int bfs(String[][] arr, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        int sum = Integer.parseInt(arr[x][y]);
        arr[x][y] = "X";
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i = 0; i < dx.length; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !arr[nx][ny].equals("X")){
                    sum += Integer.parseInt(arr[nx][ny]);
                    arr[nx][ny] = "X";
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return sum;
    }
}