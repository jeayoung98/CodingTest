import java.util.*;
 
class Solution{
    static int N, M;
    static int[][] arr;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N][N];
 
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
 
            int result = 0;
 
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result = Math.max(result, plus(j, k));
                    result = Math.max(result, cross(j, k));
                }
            }
 
            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
 
        System.out.print(sb);
    }
 
    public static int plus(int x, int y) {
        int sum = arr[x][y];
        for (int k = 1; k < M; k++) {
            if (x + k < N) sum += arr[x + k][y];
            if (x - k >= 0) sum += arr[x - k][y];
            if (y + k < N) sum += arr[x][y + k];
            if (y - k >= 0) sum += arr[x][y - k];
        }
        return sum;
    }
 
    public static int cross(int x, int y) {
        int sum = arr[x][y];
        for (int k = 1; k < M; k++) {
            if (x + k < N && y + k < N) sum += arr[x + k][y + k];
            if (x + k < N && y - k >= 0) sum += arr[x + k][y - k];
            if (x - k >= 0 && y + k < N) sum += arr[x - k][y + k];
            if (x - k >= 0 && y - k >= 0) sum += arr[x - k][y - k];
        }
        return sum;
    }
}