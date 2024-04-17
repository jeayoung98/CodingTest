import java.util.*;
class Solution {
    public long solution(long n) {
        String str = n + "";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String str1 = new String(charArray);
        StringBuilder sb = new StringBuilder(str1);
        sb.reverse();
        String str2 = sb.toString();
        long answer = Long.parseLong(str2);
        return answer;
    }
}