import java.util.*;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int sc : scoville) {
            queue.add(sc);
        }
        
        while (!queue.isEmpty()) {
            int first = queue.poll();

            if (first >= K) {
                break;
            }
            int second = queue.poll();

            int newScovile = first + (second * 2);
            queue.add(newScovile);
            answer++;
            if (queue.size() == 1 && queue.peek() < K) {
            return -1;
            }
        }

        

        return answer;
    }
}
