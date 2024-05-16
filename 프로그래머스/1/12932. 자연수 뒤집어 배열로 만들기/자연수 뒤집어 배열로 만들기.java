import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        return new StringBuilder(Long.toString(n))
            .reverse()
            .chars()
            .map(Character::getNumericValue)
            .toArray();
    }
}