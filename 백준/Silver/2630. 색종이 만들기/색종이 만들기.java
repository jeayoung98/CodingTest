import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }


    public static void divide(int x, int y, int size) {
        if (isSame(x, y, size)) {
            if (arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);
    }


    public static boolean isSame(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
