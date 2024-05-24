import java.util.stream.*;
class Solution {
    public long solution(int price, int money, int count) {
        long answer = IntStream.rangeClosed(1,count)
                       .mapToLong(i -> i * price)
                       .sum();
        
        return answer <= money ? 0 : Math.abs(answer - money);
    }
}