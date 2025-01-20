import java.util.*;
import java.io.*;

public class Main {
    static class Prey {
        int x, y, size;

        Prey(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.size = dist;
        }
    }

    static int N;
    static int[][] arr;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int totalTime = 0;
    static int sharkX, sharkY;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(parts[j]);
                if (arr[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        while(true){
            Prey fish = bfs();
            if(fish == null){
                break;
            }
            sharkX = fish.x;
            sharkY = fish.y;
            totalTime += fish.size;
            eatCount++;
            arr[sharkX][sharkY] = 0;
            if(eatCount == sharkSize){
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totalTime);
    }

    public static Prey bfs(){
        boolean[][] visited = new boolean[N][N];
        Queue<Prey> queue = new LinkedList<>();
        queue.offer(new Prey(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;
        List<Prey> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Prey current = queue.poll();
            if(current.size > minDist){
                break;
            }
            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >=0 && nx < N && ny >=0 && ny < N && !visited[nx][ny]){
                    if(arr[nx][ny] <= sharkSize){
                        visited[nx][ny] = true;
                        if(arr[nx][ny] > 0 && arr[nx][ny] < sharkSize){
                            if(current.size + 1 < minDist){
                                fishes.clear();
                                minDist = current.size + 1;
                            }
                            if(current.size +1 == minDist){
                                fishes.add(new Prey(nx, ny, current.size + 1));
                            }
                        }
                        queue.offer(new Prey(nx, ny, current.size +1));
                    }
                }
            }
        }

        if(fishes.isEmpty()){
            return null;
        }

        fishes.sort((a, b) -> {
            if(a.x != b.x){
                return a.x - b.x;
            }
            return a.y - b.y;
        });

        return fishes.get(0);
    }
}