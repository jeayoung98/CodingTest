import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String[][] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min,countRepaint(i, j));
            }
        }
        System.out.println(min);
    }

    public static int countRepaint(int x, int y) {
        int repaintW = 0;
        int repaintB = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String current = arr[x + i][y + j];
                if ((i + j) % 2 == 0) {
                    if (!current.equals("W")) repaintW++;
                    if (!current.equals("B")) repaintB++;
                } else {
                    if (!current.equals("W")) repaintB++;
                    if (!current.equals("B")) repaintW++;
                }
            }
        }

        return Math.min(repaintW, repaintB);
    }
}
