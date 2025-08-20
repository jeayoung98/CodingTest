import java.util.*;

class Solution {
    public class Truck {
        int weight, exitAt;
        Truck(int weight, int exitAt) {
            this.weight = weight;
            this.exitAt = exitAt;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> waiting = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) waiting.add(truck_weights[i]);
        Deque<Truck> deque = new ArrayDeque<>();
        int answer = 0;
        int sum = 0;

        while (!waiting.isEmpty() || !deque.isEmpty()) {
            answer++;
            
            while (!deque.isEmpty() && deque.peek().exitAt == answer) {
                sum -= deque.poll().weight;
            }
            
            if (!waiting.isEmpty()) {
                int next = waiting.peek();
                if (sum + next <= weight && deque.size() < bridge_length) {
                    waiting.poll();
                    sum += next;
                    deque.add(new Truck(next, answer + bridge_length));
                }
            }
        }
        return answer;
    }
}