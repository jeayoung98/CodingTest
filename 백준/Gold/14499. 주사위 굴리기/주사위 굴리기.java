import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Dice{
        int top, north, west, east, bottom, south;

        void roll(int dir) {
            int t = top, n = north, w = west, e = east, b = bottom, s = south;
            if(dir == 1) {
                top = w;
                bottom = e;
                west = b;
                east = t;
            }
            else if(dir == 2){
                top = e;
                bottom= w;
                east = b;
                west = t;
            } else if (dir == 3) {
                top = s;
                bottom = n;
                north = t;
                south = b;
            } else {
                top = n;
                bottom = s;
                north = b;
                south = t;
            }
        }
    }

    static int[][] arr;
    static int N, M, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];

            if (valid(nx, ny)) {
                dice.roll(dir);
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = dice.bottom;
                }else{
                    dice.bottom = arr[nx][ny];
                    arr[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                sb.append(dice.top).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean valid(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
