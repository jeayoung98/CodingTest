import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j == 0) {
                    arr[i][j] += Math.min(arr[i - 1][1], arr[i - 1][2]);
                }
                else if (j == 1) {
                    arr[i][j] += Math.min(arr[i - 1][0], arr[i - 1][2]);
                }
                else if (j == 2) {
                    arr[i][j] += Math.min(arr[i - 1][0], arr[i - 1][1]);
                }
            }
        }
        System.out.println(Math.min(arr[N - 1][0], Math.min(arr[N - 1][1], arr[N - 1][2])));
    }
}
