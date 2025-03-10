import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int N;
    static int zero;
    static int one;
    static int minusOne;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        divide(0, 0, N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void divide(int col, int row, int size) {
        int current = arr[col][row];
        boolean isSame = true;
        for (int i = col; i < col + size; i++) {
            if (!isSame) break;
            for (int j = row; j < row + size; j++) {
                if (current != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            if (current == 0) zero++;
            else if (current == 1) one++;
            else minusOne++;
        } else {
            int newSize = size / 3;
            divide(col, row, newSize);
            divide(col, row + newSize, newSize);
            divide(col, row + newSize * 2, newSize);
            divide(col + newSize * 2, row, newSize);
            divide(col + newSize * 2, row + newSize, newSize);
            divide(col + newSize * 2, row + newSize * 2, newSize);
            divide(col + newSize, row, newSize);
            divide(col + newSize, row + newSize, newSize);
            divide(col + newSize, row + newSize * 2, newSize);

        }
    }
}
