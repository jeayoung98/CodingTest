import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b;
            result += sum;

            pq.add(sum);
        }

        System.out.println(result);
    }
}