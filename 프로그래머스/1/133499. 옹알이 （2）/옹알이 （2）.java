import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        String[] bab = {"aya", "ye", "woo", "ma"};
        
        for (String word : babbling) {
            if (isPossible(word,bab)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPossible(String word,String[] bab) {
        int index = 0;
        String last = "";
        while (index < word.length()) {
            boolean found = false;
            for (String pattern : bab) {
                if (word.startsWith(pattern, index)) {
                    // 연속된 같은 패턴 검사
                    if (pattern.equals(last)) {
                        return false;
                    }
                    // 패턴을 찾았다면 index를 업데이트
                    index += pattern.length();
                    last = pattern;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }  
        return true;
    }
}