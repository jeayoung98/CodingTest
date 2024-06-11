import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(char c1 : c){
            if(stack.isEmpty()) stack.push(c1);
            else{
                if(stack.peek() != c1) stack.push(c1);
                else stack.pop();
            }
            
        }
        return stack.isEmpty()?1:0;
    }
}