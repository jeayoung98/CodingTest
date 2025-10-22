import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                if (open == 0) return false;
                open--;
            }
        }
        
        answer = open == 0 ? true:false;
        return answer;
    }
}