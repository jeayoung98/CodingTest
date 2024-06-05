import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for(int i = 0;i < charArr.length; i++){
            char bracket = charArr[i];
            if(!stack.empty()){
                if(bracket==('(')){
                    stack.push(bracket);
                }else if(bracket==(')')){
                    stack.pop();
                }
            }else {
                if(bracket==('(')){
                    stack.push(bracket);
                }else if(bracket==(')')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}