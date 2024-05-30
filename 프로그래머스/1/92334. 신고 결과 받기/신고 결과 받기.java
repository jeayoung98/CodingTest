import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 사용자가 신고 받은 횟수
        Map<String,Integer> map = new HashMap<>();
        // 사용자가 신고한 유저들
        Map<String, Set<String>> map1 = new HashMap<>();
        
        for(String str : report){
            String[] strArr = str.split(" ");
            Set<String> set = map1.getOrDefault(strArr[0], new HashSet<>());
            // 사용자가 신고한 유저에 포함 안될 경우 +1
            if(!set.contains(strArr[1])){
                set.add(strArr[1]);
                map.put(strArr[1], map.getOrDefault(strArr[1], 0) + 1);
                map1.put(strArr[0], set);
            }
        }
        
        // 신고 횟수가 k번 이상인 유저
        Set<String> suspended = new HashSet<>();
        for (String user : map.keySet()) {
            if (map.get(user) >= k) {
                suspended.add(user);
            }
        }
        
        // 신고한 유저 메일 횟수 계산
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            if (map1.containsKey(user)) {
                for (String reportUser : map1.get(user)) {
                    if (suspended.contains(reportUser)) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}
