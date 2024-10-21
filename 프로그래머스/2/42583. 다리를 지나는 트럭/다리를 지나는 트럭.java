import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) { 
        int totalWeight = 0;
        int answer = 0;
        Deque<Integer> bridge = new ArrayDeque<>();
        int i = 0;

        while (i < truck_weights.length) {
            answer++;
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
        return answer + bridge_length;
    }
}
