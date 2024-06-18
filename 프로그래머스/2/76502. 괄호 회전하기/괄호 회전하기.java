import java.util.*;

class Solution {
    public String swap(String s ){
        String temp = s.substring(0,1);
        return s.substring(1) + temp;
    }
    public boolean chk(String s){
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (current == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (current == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            s = swap(s);
            if(chk(s)){
                answer++;
            }
        }
        return answer;
    }
}