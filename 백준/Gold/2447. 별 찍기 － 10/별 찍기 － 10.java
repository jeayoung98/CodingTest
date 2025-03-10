import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringBuilder sb = new StringBuilder();
        divide(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] == 1 ? " " : "*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void divide(int col, int row, int size) {
        int newSize = size / 3;
        if (col < N && size > 0) {
            for (int i = col + newSize; i < col + newSize * 2; i++) {
                for (int j = row + newSize; j < row + newSize * 2; j++) {
                    arr[i][j] = 1;
                }
            }

            divide(col, row, newSize);
            divide(col, row + newSize, newSize);
            divide(col, row + newSize * 2, newSize);
            divide(col + newSize, row , newSize);
            divide(col + newSize, row + newSize, newSize);
            divide(col+ newSize, row+ newSize * 2, newSize);
            divide(col + newSize * 2, row, newSize);
            divide(col + newSize * 2, row + newSize, newSize);
            divide(col + newSize * 2, row + newSize * 2, newSize);

        }


    }
}
