import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i + 1] > arr[i + 2]) {
                int two = Math.min(arr[i], arr[i + 1] - arr[i + 2]);

                arr[i] -= two;
                arr[i + 1] -= two;

                result += 5 * two;
            }

            int three = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));

            arr[i] -= three;
            arr[i + 1] -= three;
            arr[i + 2] -= three;

            result += 7 * three;

            int one = arr[i];

            result += 3 * one;
            arr[i] = 0;
        }

        System.out.println(result);
    }
}