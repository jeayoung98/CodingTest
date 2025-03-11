import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int N;
    static long M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Long.parseLong(s[1]);

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(a -> Integer.parseInt(a) % 1000).toArray();
        }
        StringBuilder sb = new StringBuilder();

        int[][] result = matrixPow(arr, M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static int[][] matrixPow(int[][] matrix,long size) {
        if(size == 1) {
            return matrix;
        }
        int[][] half = matrixPow(matrix, size / 2);
        int[][] result = matrixMulti(half, half);
        if(size % 2 == 1) {
            result = matrixMulti(result, matrix);
        }
        return result;
    }

    public static int[][] matrixMulti(int[][] matrix1,int[][] matrix2) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (long) matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = (int)(sum % 1000);
            }
        }
        return result;
    }

}
