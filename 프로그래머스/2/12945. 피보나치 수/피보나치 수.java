import java.util.stream.Stream;

class Solution {
    public int solution(int n) {
        return Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], (f[0] + f[1]) % 1234567})
                     .limit(n)
                     .map(f -> f[1])
                     .reduce((a, b) -> b)
                     .orElse(0);
    }
}
