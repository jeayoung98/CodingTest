import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[]{0,0};
        while(!s.equals("1")){
            answer[1] += s.chars()
                          .filter(i -> i != '1')
                          .count();
            String result = s.chars()
                             .filter(i -> i == '1')
                             .mapToObj(i -> String.valueOf((char) i))
                             .collect(Collectors.joining());
            s = Integer.toBinaryString(result.length());
            answer[0]++;
        }
        return answer;
    }
}