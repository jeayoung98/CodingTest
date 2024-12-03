import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        long N = Long.parseLong(s[0]);
        long M = Long.parseLong(s[1]);
        long K = Long.parseLong(s[2]);
        
        long result = 1;
        N = N % K;

        while (M > 0) {
            if ((M & 1) == 1) {
                result = (result * N) % K;
            }
            N = (N * N) % K;
            M = M >> 1;
        }
        System.out.println(result);
    }
}
