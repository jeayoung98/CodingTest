import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            list.add(arr[i], i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
