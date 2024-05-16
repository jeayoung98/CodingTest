import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : ingredient){
            stack.push(i);
            if(stack.size() >= 4){
                boolean bread1 = stack.elementAt(stack.size()-1) == 1;
                boolean meet = stack.elementAt(stack.size()-2) == 3;
                boolean vegetable = stack.elementAt(stack.size()-3) == 2;
                boolean bread2 = stack.elementAt(stack.size()-4) == 1;
                if(bread1 && meet && vegetable && bread2) {
                    answer++;
                    stackPop(stack);
                }
            }
        }
        return answer;
    }
    public void stackPop(Stack<Integer> stack){
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}