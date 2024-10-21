import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) { 
        int totalWeight = 0;
        int answer = 0;
        Deque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int i = 0;

        while (i < truck_weights.length) {
            time++;

            if (bridge.size() == bridge_length) {
                totalWeight -= bridge.pollFirst();
            }

            if (totalWeight + truck_weights[i] <= weight && bridge.size() < bridge_length) {
                bridge.add(truck_weights[i]);
                totalWeight += truck_weights[i];
                i++;
            } else {
                bridge.add(0);
            }
        }

        answer = time + bridge_length;
        return answer;
    }
}
