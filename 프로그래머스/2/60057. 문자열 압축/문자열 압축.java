import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();
            String last = s.substring(0, i);
            int count = 1;
            
            for (int j = i; j < s.length(); j += i) {
                String current;
                if (j + i > s.length()) {
                    current = s.substring(j);
                } else {
                    current = s.substring(j, j + i);
                }
                
                if (last.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        result.append(count);
                    }
                    result.append(last);
                    last = current;
                    count = 1;
                }
            }
            if (count > 1) {
                result.append(count);
            }
            result.append(last);
            
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
