import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        list.sort((a,b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        Queue<Integer> queue = new PriorityQueue<>();

        for (int[] arr : list) {
            if (!queue.isEmpty() && queue.peek() <= arr[0]) {
                queue.poll();
            }
            queue.add(arr[1]);
        }
        System.out.println(queue.size());

    }
}
