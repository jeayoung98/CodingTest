import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int totalMax = -Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = Integer.parseInt(arr[i]);
            max = Math.max(current, max + current);
            totalMax = Math.max(max, totalMax);
        }

        System.out.println(totalMax);

    }
}
