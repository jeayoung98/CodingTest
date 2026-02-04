import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            move(K, H);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                if (i == 0) result += 1;
                else if (i == 1) result += 2;
                else if (i == 2) result += 4;
                else result += 8;
            }
        }
        System.out.println(result);
    }

    private static void move(int k, int h) {
        int idx = k - 1;
        int[] dir = new int[4];
        dir[idx] = h;

        // 왼쪽 전파 (회전 전 상태 기준!)
        for (int i = idx; i - 1 >= 0; i--) {
            if (arr[i][6] == arr[i - 1][2]) break;
            dir[i - 1] = -dir[i];
        }

        // 오른쪽 전파
        for (int i = idx; i + 1 < 4; i++) {
            if (arr[i][2] == arr[i + 1][6]) break;
            dir[i + 1] = -dir[i];
        }

        // 한 번에 회전 적용
        for (int i = 0; i < 4; i++) {
            if (dir[i] != 0) rotate(i, dir[i]);
        }
    }

    private static void rotate(int idx, int d) {
        int[] old = arr[idx].clone();

        if (d == 1) { // 시계 방향
            for (int i = 0; i < 8; i++) {
                arr[idx][i] = old[(i - 1 + 8) % 8];
            }
        } else { // 반시계 방향
            for (int i = 0; i < 8; i++) {
                arr[idx][i] = old[(i + 1) % 8];
            }
        }
    }
}
