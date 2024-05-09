import java.util.*;

public class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>();

        // skip에 포함되지 않은 문자 추가
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!skip.contains(String.valueOf(ch))) {
                list.add(ch);
            }
        }

        // 주어진 문자열 s의 각 문자에 대하여 변환 수행
        for (char ch : s.toCharArray()) {
            int currentIdx = list.indexOf(ch);
            char c = list.get((currentIdx + index) % list.size());
            result.append(c);
        }
        answer = result.toString();
        return answer;
    }
}