import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int N;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        divide(0, 0, N);
        System.out.println(result.toString());
    }

    public static void divide(int row, int col, int size) {
        int num = arr[row][col];
        boolean isSame = true;
        for (int i = row; i < row + size; i++) {
            if (!isSame) break;
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != num) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            result.append(num);
        } else {
            int newSize = size / 2;
            result.append("(");
            divide(row, col, newSize);
            divide(row, col + newSize, newSize);
            divide(row + newSize, col, newSize);
            divide(row + newSize, col + newSize, newSize);
            result.append(")");
        }
    }
}
