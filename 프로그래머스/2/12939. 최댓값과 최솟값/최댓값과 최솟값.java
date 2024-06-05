import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        int[] i = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .toArray();
        int max = Arrays.stream(i).max().orElse(0);
        int min = Arrays.stream(i).min().orElse(0);
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }
}