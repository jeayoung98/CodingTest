import java.util.function.*;
class Solution {
    public int solution(int num1, int num2) {
        BiFunction<Integer, Integer, Integer> func = (a, b) -> a + b;
        int answer = func.apply(num1,num2);
        return answer;
    }
}