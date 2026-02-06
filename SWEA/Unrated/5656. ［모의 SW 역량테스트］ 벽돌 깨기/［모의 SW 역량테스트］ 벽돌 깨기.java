import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,W,H, result = 0, min = Integer.MAX_VALUE;
    static int[][] arr, mainArr;
    static int[] pArr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            min = Integer.MAX_VALUE;
            // count times
            N = Integer.parseInt(st.nextToken());
            pArr = new int[N];
            // matrix size
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr = new int[H][W];
            mainArr = new int[H][W];


            // init
            for (int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < W; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    mainArr[j][k] = arr[j][k];
                }
            }

            dfs(0);

            // 깨고 내리는 로직
            sb.append("#").append(i + 1).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    // find duplicate permutation
    static void dfs(int depth) {
        if (depth == N) {
            result = 0;
            for (int i = 0; i < H; i++){
                for (int j = 0; j < W; j++) {
                    arr[i][j] = mainArr[i][j];
                }
            }
            for (int i = 0; i < pArr.length; i++) {
                bfs(pArr[i]);
            }
            min = Math.min(min, countRemainBricks());
            return;
        }

        for (int i = 0; i < W; i++) {
            pArr[depth] = i;
            dfs(depth + 1);
        }
    }

    // check bricks and increase count when current bricks is not 0
    public static void bfs(int y) {
        int x = 0;
        while (x < H && arr[x][y] == 0) {
            x++;
        }
        if (x == H) return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            // visited
            int num = arr[cx][cy];
            arr[cx][cy] = 0;

            for (int j = 0; j < 4; j++) {
                for (int k = 1; k < num; k++) {
                    int nx = cx + dx[j] * k;
                    int ny = cy + dy[j] * k;
                    if (isValid(nx,ny)) {
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
        letPullDown();
    }

    public static boolean isValid(int cx, int cy) {
        return cx >= 0 && cx < H && cy >= 0 && cy < W && arr[cx][cy] != 0;
    }

    public static void letPullDown() {
        for (int i = 0; i < W; i++) {
            int idx = H - 1;
            for (int j = H - 1; j >= 0; j--) {
                if (arr[j][i] != 0) {
                    arr[idx--][i] = arr[j][i];
                }
            }
            // 위쪽 정리
            for (int j = idx; j >= 0; j--) arr[j][i] = 0;
        }
    }


    public static int countRemainBricks() {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] != 0) count++;
            }
        }
        return count;
    }
}
