import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] countZero = new int[41];
        int[] countOne = new int[41];
        countZero[0] = 1;
        countOne[0] = 0;
        countZero[1] = 0;
        countOne[1] = 1;
        for (int i = 2; i < 41; i++) {
            countZero[i] = countZero[i - 1] + countZero[i - 2];
            countOne[i] = countOne[i - 1] + countOne[i - 2];
        }
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            System.out.println(countZero[M] + " " + countOne[M]);
        }
    }
}
