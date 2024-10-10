import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for(String log : record) {
            String[] parts = log.split(" ");
            String command = parts[0];
            String userId = parts[1];
            String userName = parts.length > 2 ? parts[2] : "";
            
            switch(command) {
                case "Enter":
                    map.put(userId, userName);
                    list.add(new String[] {userId , "님이 들어왔습니다."});
                    break;
                case "Leave":
                    list.add(new String[] {userId , "님이 나갔습니다."});
                    break;
                case "Change":
                    map.put(userId, userName);
                    break;
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = map.get(list.get(i)[0]) + list.get(i)[1];
        }
        
        return answer;
    }
}
