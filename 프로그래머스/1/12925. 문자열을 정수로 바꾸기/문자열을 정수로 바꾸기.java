import java.util.stream.*;

class Solution {
    public int solution(String s) {
        return (s.startsWith("-") ? -1 : 1) * s.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .reduce(0, (a, b) -> a * 10 + b);
    }
}