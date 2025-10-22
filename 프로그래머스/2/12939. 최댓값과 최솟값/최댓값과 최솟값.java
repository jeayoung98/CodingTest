import java.util.*;

class Solution {
    public String solution(String s) {
        int[] a = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        StringBuilder sb = new StringBuilder();
        sb.append(a[0]).append(" ").append(a[a.length - 1]);
        return sb.toString();
    }
}