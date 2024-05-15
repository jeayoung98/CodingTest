import java.util.stream.*;
class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(1,n/2)
            .filter(a -> n % a == 0)
            .sum() + n;
    }
}