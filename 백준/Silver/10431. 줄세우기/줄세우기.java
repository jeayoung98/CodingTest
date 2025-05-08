import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();;
            int count = getCount(arr);

            sb.append(arr[0]).append(" ").append(count).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int getCount(int[] arr) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j < arr.length; j++) {
            int height = arr[j];
            int currentIndex = list.size();
            for (int k = 0; k < list.size(); k++) {
                if (list.get(k) > height) {
                    currentIndex = k;
                    break;
                }
            }
            count += list.size() - currentIndex;
            list.add(currentIndex, height);
        }
        return count;
    }
}