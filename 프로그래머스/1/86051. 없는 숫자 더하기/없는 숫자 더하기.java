import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] numbers) {
        int sum = Arrays.stream(numbers)
            .sum();
        return 45 - sum;
    }
}