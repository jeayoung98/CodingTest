import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(N);
        br.readLine();
        int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M.length; i++) {
            if (Arrays.binarySearch(N, M[i]) >= 0) {
                sb.append("1 ");
            } else sb.append("0 ");
        }
        System.out.println(sb.toString().trim());
    }
}
