import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fibo = new int[N + 1];
        fibo[0] = 1;
        fibo[1] = 2;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 10007;
        }
        System.out.println(fibo[N-1]%10007);
    }
}
