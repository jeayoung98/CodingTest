import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(arr);
        }

        for (int[] i : list) {
            int[] current = i;
            int count = 1;
            for (int[] i1 : list) {
                if (current[0] < i1[0] && current[1] < i1[1]) count++;
            }
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString());
    }
}
