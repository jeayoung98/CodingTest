import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        if (cacheSize == 0) {
            return cities.length * 5; 
        }

        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            if (deque.contains(lowerCity)) {
                deque.remove(lowerCity); 
                deque.offerLast(lowerCity);
                answer += 1; 
            } else {
                if (deque.size() >= cacheSize) {
                    deque.pollFirst(); 
                }
                deque.offerLast(lowerCity); 
                answer += 5; 
            }
        }
        return answer;
    }
}