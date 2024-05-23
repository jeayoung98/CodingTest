import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        int sum = IntStream.rangeClosed(left, right).sum();
        int odd = IntStream.rangeClosed(left, right)
                           .filter(i -> isSquare(i))
                           .sum()*2;
        return sum - odd;
    }

    private boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}