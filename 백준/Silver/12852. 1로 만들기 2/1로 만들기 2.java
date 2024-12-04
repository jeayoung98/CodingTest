import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] pre = new int[N + 1];

        arr[1] = 0;
        pre[1] = 0;

        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            pre[i] = i - 1;

            if (i % 2 == 0) {
                if (arr[i / 2] + 1 < arr[i]) {
                    arr[i] = arr[i / 2] + 1;
                    pre[i] = i / 2;
                }
            }

            if (i % 3 == 0) {
                if (arr[i / 3] + 1 < arr[i]) {
                    arr[i] = arr[i / 3] + 1;
                    pre[i] = i / 3;
                }
            }
        }

        System.out.println(arr[N]);

        Queue<Integer> queue = new LinkedList<>();
        int current = N;
        while (current != 0) {
            queue.add(current);
            current = pre[current];
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
