import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String string = br.readLine();
        StringBuilder sb = new StringBuilder("IOI");

        for (int i = 0; i < N - 1; i++) {
            sb.append("OI");
        }
        long result = 0;
        for (int i = 0; i < M - (2 * N); i++) {
            String substring = string.substring(i, i + 2 * N + 1);
            if (sb.toString().equals(substring)) result++;
        }
        System.out.println(result);

    }
}
