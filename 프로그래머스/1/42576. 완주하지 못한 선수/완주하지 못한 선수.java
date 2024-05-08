import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자, 카운트 증가
        for(String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        // 완주자, 카운트 감소
        for(String str : completion) {
            map.put(str, map.get(str) - 1);
        }
        
        // 완주하지 못한 참가자 찾기 
        for(String str : participant) {
            if(map.get(str) > 0) {
                answer = str;
                break;
            }
        }
        return answer;
    }
}