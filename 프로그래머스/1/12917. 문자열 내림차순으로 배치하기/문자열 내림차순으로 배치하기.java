import java.util.*;
class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new StringBuilder(new String(charArr)).reverse().toString();
    }
}