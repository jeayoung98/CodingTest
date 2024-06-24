import java.util.*;

class Solution {    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();    

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            if (isPossible(i, wantMap, discount)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPossible(int start, Map<String, Integer> wantMap, String[] discount) {
        Map<String, Integer> countMap = new HashMap<>();

        // 10일 간 할인된 제품을 countMap에 기록
        for (int i = start; i < start + 10; i++) {
            countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
        }

        // wantMap과 countMap 비교
        for (String key : wantMap.keySet()) {
            if (!wantMap.get(key).equals(countMap.getOrDefault(key, 0))) {
                return false;
            }
        }

        return true;
    }
}
