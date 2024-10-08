import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0; 

        for (int i = 1; i <= order.length; i++) {
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop(); 
                index++; 
            }

            if (i == order[index]) {
                index++; 
            } else {
                stack.push(i);
            }
        }

        while (!stack.isEmpty() && stack.peek() == order[index]) {
            stack.pop(); 
            index++; 
        }

        return index--; 
    }
}
