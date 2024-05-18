import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(2, n - 1)
            .filter(i -> n % i == 1)
            .min()
            .orElse(1);
    }
}