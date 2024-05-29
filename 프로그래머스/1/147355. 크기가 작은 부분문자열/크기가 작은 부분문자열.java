import java.util.stream.*;

class Solution {
    public int solution(String t, String p) {
        return (int) IntStream.rangeClosed(0, t.length() - (int) p.length())
                .filter(i -> Long.parseLong(t.substring(i, i + (int)p.length())) <= Long.parseLong(p))
                .count();
    }
}