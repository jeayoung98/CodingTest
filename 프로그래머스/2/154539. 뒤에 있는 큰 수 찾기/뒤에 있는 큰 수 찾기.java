import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]) {
                answer[deque.pollLast()] = numbers[i];
            }
            deque.offerLast(i);
        }
        while (!deque.isEmpty()) {
            answer[deque.pollLast()] = -1;
        }
        return answer;
    }
}
