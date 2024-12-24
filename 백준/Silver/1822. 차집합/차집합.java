import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(M);
        int result = 0;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N.length; i++) {
            if (Arrays.binarySearch(M, N[i]) < 0) {
                result++;
                list.add(N[i]);
            }
        }
        Collections.sort(list);
        list.forEach(a -> sb.append(a).append(" "));
        System.out.println(result);
        if (result != 0) {
            System.out.println(sb.toString().trim());
        }
    }
}
