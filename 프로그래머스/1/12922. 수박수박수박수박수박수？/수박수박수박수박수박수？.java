import java.util.stream.*;
import java.util.*;
class Solution {
    public String solution(int n) {
        return IntStream.rangeClosed(1,n)
            .mapToObj(i -> i % 2 == 0?"박":"수")
            .collect(Collectors.joining());
    }
}