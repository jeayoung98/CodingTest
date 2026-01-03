import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if ((long) C * R < K) {
            System.out.println(0);
            return;
        }

        int[][] arr = new int[R][C];

        int top = 0;
        int bottom = R - 1;
        int left = 0;
        int right = C - 1;

        int cnt = 1;

        while (top <= bottom && left <= right) {
            for (int i = bottom; i >= top; i--) {
                arr[i][left] = cnt;
                if (cnt == K) {
                    System.out.println((left + 1) + " " + (R - i));
                    return;
                }
                cnt++;
            }
            left++;

            for (int j = left; j <= right; j++) {
                arr[top][j] = cnt;
                if (cnt == K) {
                    System.out.println((j + 1) + " " + (R - top));
                    return;
                }
                cnt++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                arr[i][right] = cnt;
                if (cnt == K) {
                    System.out.println((right + 1) + " " + (R - i));
                    return;
                }
                cnt++;
            }
            right--;

            for (int j = right; j >= left; j--) {
                arr[bottom][j] = cnt;
                if (cnt == K) {
                    System.out.println((j + 1) + " " + (R - bottom));
                    return;
                }
                cnt++;
            }
            bottom--;
        }
    }
}
