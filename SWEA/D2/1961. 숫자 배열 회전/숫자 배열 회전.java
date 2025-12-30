import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int K = sc.nextInt();
            int[][] arr = new int[K][K];

            for (int r = 0; r < K; r++) {
                for (int c = 0; c < K; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
            String[][] result = new String[K][3];
            
            for (int row = 0; row < K; row++) {
                result[row][0] = buildLine(arr, 90, row);
                result[row][1] = buildLine(arr, 180, row);
                result[row][2] = buildLine(arr, 270, row);
            }

            System.out.println("#" + tc);
            for (int r = 0; r < K; r++) {
                System.out.println(result[r][0] + " " + result[r][1] + " " + result[r][2]);
            }
        }
    }


    static String buildLine(int[][] a, int rot, int row) {
        int n = a.length;
        StringBuilder sb = new StringBuilder();

        for (int col = 0; col < n; col++) {
            int r, c;

            if (rot == 90) {
                r = n - 1 - col;
                c = row;
            } else if (rot == 180) {
                r = n - 1 - row;
                c = n - 1 - col;
            } else {
                r = col;
                c = n - 1 - row;
            }

            sb.append(a[r][c]);
        }
        return sb.toString();
    }
}