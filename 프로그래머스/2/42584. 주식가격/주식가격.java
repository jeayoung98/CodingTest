import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {

        while (!deque.isEmpty() && prices[i] < prices[deque.peek()]) {
            int index = deque.pop();
            answer[index] = i - index; 
        }
        deque.push(i); 
        }

        while (!deque.isEmpty()) {
            int index = deque.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }
}
