import java.util.stream.*;

class Solution {
    boolean solution(String s) {
        int count = s.toLowerCase().chars() // 소문자로 변환후 intStream으로
            .map(c -> c == 'p' ? 1 : c == 'y' ? -1 : 0)
            .sum();
        
        return count == 0; // 카운트가 0이면 참을 반환
    }
}