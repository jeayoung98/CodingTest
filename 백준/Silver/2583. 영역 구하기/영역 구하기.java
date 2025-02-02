import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    static int M, N, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        arr = new int[M][N];
        for (int i = 0; i < K; i++) {
            String[] arr2 = br.readLine().split(" ");
            int row1 = Integer.parseInt(arr2[0]);
            int col1 = Integer.parseInt(arr2[1]);
            int row2 = Integer.parseInt(arr2[2]);
            int col2 = Integer.parseInt(arr2[3]);

            for (int j = col1; j < col2; j++) {
                for (int k = row1; k < row2; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    list.add(bfs(i, j));
                    count++;
                }
            }
        }
        System.out.println(count);
        List<Integer> list1 = list.stream().sorted((a, b) -> a - b).collect(Collectors.toList());
        for (int i : list1) {
            System.out.print(i+" ");
        }
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        arr[startX][startY] = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    count++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}