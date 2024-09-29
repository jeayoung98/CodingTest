import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<topping.length; i++) {
            if (map.containsKey(topping[i])) {
                int temp = map.get(topping[i]);
                map.put(topping[i], temp+1);
            } else {
                map.put(topping[i], 1);
            }
        }

        for (int i=0; i<topping.length-1; i++) {
            set.add(topping[i]);
            int temp = map.get(topping[i]);
            if (temp == 1) {
                map.remove(topping[i]);
            } else {
                map.put(topping[i], temp-1);
            }
            answer += set.size()==map.size() ? 1 : 0;
        }

        return answer;
    }
}