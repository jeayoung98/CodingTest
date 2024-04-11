import java.util.*;
class Solution {
    public int solution(int[] array) { 
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        int answer = -1;

        for (int num : array) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                answer = num;
            } else if (frequency == maxFrequency) {
                answer = -1;
            }
        }
        return answer;
    }
}