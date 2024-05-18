import java.util.stream.*;

class Solution {
    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, n)
                         .map(i -> (long)x * i)
                         .toArray();
    }
}