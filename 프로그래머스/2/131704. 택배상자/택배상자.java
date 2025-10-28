import java.util.*;

class Solution {
    int answer, index = 0;
    public int solution(int[] order) {
        
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            putToTruck(stack, order);
            if (order[index] == i) {
                answer++; 
                index++;
            } else {
                stack.push(i);
            }
        }
        putToTruck(stack, order);

        return answer;
    }
    
    public void putToTruck(Stack<Integer> stack, int[] order){
        while (!stack.isEmpty() && stack.peek() == order[index]) {
            stack.pop();
            answer++;
            index++;
        }
    }
}
