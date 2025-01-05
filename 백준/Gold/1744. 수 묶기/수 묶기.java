import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> negativeQueue = new PriorityQueue<>();

        int countOnes = 0;
        int countZeros = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positiveQueue.add(num);
            } else if (num == 1) {
                countOnes++;
            } else if (num == 0) {
                countZeros++;
            } else {
                negativeQueue.add(num);
            }
        }

        int result = 0;

        while (positiveQueue.size() > 1) {
            int first = positiveQueue.poll();
            int second = positiveQueue.poll();
            result += first * second;
        }

        if (!positiveQueue.isEmpty()) {
            result += positiveQueue.poll();
        }

        result += countOnes;

        while (negativeQueue.size() > 1) {
            int first = negativeQueue.poll();
            int second = negativeQueue.poll();
            result += first * second;
        }

        if (!negativeQueue.isEmpty() && countZeros <= 0) {
            result += negativeQueue.poll();
        }

        System.out.println(result);
    }
}
