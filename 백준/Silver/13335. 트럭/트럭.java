import java.io.*;
import java.util.*;

public class Main {
    static class Truck {
        int weight, exitAt;
        Truck(int weight, int exitAt) {
            this.weight = weight;
            this.exitAt = exitAt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> waiting = new ArrayDeque<>();
        for (int i = 0; i < N; i++) waiting.add(Integer.parseInt(st.nextToken()));

        Queue<Truck> bridge = new ArrayDeque<>();
        int time = 0;
        int sum = 0;

        while (!waiting.isEmpty() || !bridge.isEmpty()) {
            time++;
            
            while (!bridge.isEmpty() && bridge.peek().exitAt == time) {
                sum -= bridge.poll().weight;
            }
            
            if (!waiting.isEmpty()) {
                int next = waiting.peek();
                if (sum + next <= K && bridge.size() < M) {
                    waiting.poll();
                    sum += next;
                    bridge.add(new Truck(next, time + M));
                }
            }
        }

        System.out.println(time);
    }
}
