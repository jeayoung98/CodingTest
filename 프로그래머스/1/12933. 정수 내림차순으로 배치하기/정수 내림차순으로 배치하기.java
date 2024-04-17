import java.util.*;
class Solution {
    public long solution(long n) {
        String str = n + "";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String str1 = new String(charArray);
        StringBuilder sb = new StringBuilder(str1);
        long answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
}