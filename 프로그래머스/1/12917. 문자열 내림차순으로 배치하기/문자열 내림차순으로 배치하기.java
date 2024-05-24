import java.util.stream.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}