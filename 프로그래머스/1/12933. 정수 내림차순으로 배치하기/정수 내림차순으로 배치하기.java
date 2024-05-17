import java.util.stream.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        return Long.parseLong(str.chars()
            .mapToObj(c -> (char) c)
            .sorted(Comparator.reverseOrder())
            .map(String::valueOf)
            .collect(Collectors.joining()));
    }
}