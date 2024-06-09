import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(String name : participant){
            map.put(name,map.getOrDefault(name,0)+1);
        }
        for(String complete : completion){
            map.put(complete,map.get(complete)-1);
        }
        
        for(String name : map.keySet()){
            if(map.get(name) != 0){
                answer = name;
            }
        }
        return answer;
    }
}