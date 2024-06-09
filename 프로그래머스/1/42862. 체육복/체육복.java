import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        // 모든 학생이 체육복 1개씩 가지고 있음
        for(int i = 1; i<=n;i++){
            map.put(i,1);
        }
        
        // 누가 훔쳐감 ㅅㅂ
        for(int i : lost){
            map.put(i,map.get(i)-1);
        }
        
        // 여분 체육복
        for(int i : reserve){
            map.put(i,map.get(i)+1);
        }
        
        // 옆에 애 빌려줌
        for(int i = 1; i <= n; i++){
            if (map.get(i) > 1) {
                if (i > 1 && map.get(i - 1) == 0) {
                    map.put(i - 1, 1);
                    map.put(i, 1);
                } else if (i < n && map.get(i + 1) == 0) {
                    map.put(i + 1, 1);
                    map.put(i, 1);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(map.get(i) >= 1) answer++;
        }
        
        return answer;
    }
}