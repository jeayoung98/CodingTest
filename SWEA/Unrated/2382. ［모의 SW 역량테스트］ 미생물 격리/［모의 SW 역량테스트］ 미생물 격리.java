import java.io.*;
import java.util.*;

public class Solution {
    public static class Micro{
        int size,x,y,dir;
        boolean isSurvive;

        public Micro(int size, int x, int y, int dir) {
            this.size = size;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isSurvive = true;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static Micro[] micros;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            micros = new Micro[K + 1];

            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int size = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                switch (dir) {
                    case 1: dir = 0; break; // 상
                    case 2: dir = 2; break; // 하
                    case 3: dir = 1; break; // 좌
                    case 4: dir = 3; break; // 우
                }
                micros[j] = new Micro(size, x, y, dir);
            }

            for (int t = 0; t < M; t++) {
                moveMicro();
                reverseDir();
                combine();
            }

            int sum = Arrays.stream(micros)
                    .filter(m -> m != null && m.isSurvive)
                    .mapToInt(m -> m.size)
                    .sum();

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

    public static void moveMicro() {
        for (int i = 1; i < micros.length; i++) {
            if (micros[i].isSurvive) {
                int dir = micros[i].dir;
                micros[i].x += dx[dir];
                micros[i].y += dy[dir];
            }
        }
    }

    public static void reverseDir() {
        for (int i = 1; i < micros.length; i++) {
            if (!micros[i].isSurvive) continue;

            if (micros[i].x == 0 || micros[i].x == N - 1 || micros[i].y == 0 || micros[i].y == N - 1) {
                micros[i].size /= 2;
                if (micros[i].size == 0) {
                    micros[i].isSurvive = false;
                    continue;
                }
                micros[i].dir = (micros[i].dir + 2) % 4;
            }
        }
    }

    public static void combine() {
        for (int r = 0; r < N; r++) Arrays.fill(arr[r], 0);

        int[][] max = new int[N][N];

        for (int i = 1; i < micros.length; i++) {
            if (!micros[i].isSurvive) continue;

            int x = micros[i].x;
            int y = micros[i].y;

            if (arr[x][y] == 0) {
                // 첫 군집이면 등록
                arr[x][y] = i;
                max[x][y] = micros[i].size;
            } else {
                int rep = arr[x][y];

                if (micros[i].size > max[x][y]) {
                    max[x][y] = micros[i].size;
                    micros[rep].dir = micros[i].dir;
                }

                micros[rep].size += micros[i].size;
                micros[i].isSurvive = false;
            }
        }
    }
}