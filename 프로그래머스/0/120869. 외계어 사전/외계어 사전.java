import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for (String dicStr : dic) {
            boolean isContain = true;
            for (String str : spell) {
                if (dicStr.indexOf(str) == -1) {
                    isContain = false;
                    break;
                }
            }
            if (isContain) answer = 1;
        }
        return answer;
    }
}