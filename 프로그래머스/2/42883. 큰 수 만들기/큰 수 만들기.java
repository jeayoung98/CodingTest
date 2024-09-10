import java.util.stream.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        if(stack.size() == number.length()) {
            while(k > 0){
                stack.pop();
                k--;
            }
            
        }
        
        // StringBuilder로 변환하고 불필요한 문자 제거
        StringBuilder answer = new StringBuilder();
        for (char ch : stack) {
            answer.append(ch);
        }

        return answer.toString();
    }
}