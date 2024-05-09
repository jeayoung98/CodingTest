import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();
        // X의 정수 등장횟수
        for (char c : X.toCharArray()) {
            mapX.put(c, mapX.getOrDefault(c, 0) + 1);
        }
        // Y의 정수 등장횟수
        for (char c : Y.toCharArray()) {
            mapY.put(c, mapY.getOrDefault(c, 0) + 1);
        }

        // X와 Y비교 후 겹치는 정수 list에 넣기
        List<Character> list = new ArrayList<>();
        for (char c : mapX.keySet()) {
            if (mapY.containsKey(c)) {
                int count = Math.min(mapX.get(c), mapY.get(c));
                for (int j = 0; j < count; j++) {
                    list.add(c);
                }
            }
        }
        // 아무것도 없으면 -1
        if(list.size()==0) return "-1";
        
        // 0밖에 없으면 0
        int sum = 0;
        for(char c : list){
            sum += (int)c;
        }
        if(sum % 48 == 0) return "0"; // 0의 아스키코드48
        Collections.reverse(list);
        
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        answer = sb.toString();
        
        return answer;
    }
}