import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] answer = new int[prices.length];

    for (int i = 0; i < prices.length; i++) {
        answer[i] = prices.length - i - 1;
    }

    for (int i = 0; i < prices.length; i++) {
        while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
            int idx = deque.pollLast();
            answer[idx] = i - idx; 
        }
        deque.offerLast(i);
    }
        
    return answer;
    }
}
