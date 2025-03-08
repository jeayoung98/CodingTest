import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = Arrays.stream(diffs).max().orElse(1);

        while(left <= right){
            int currentLevel = (left + right) / 2;
            long currentTime = 0;
            for(int i = 0; i < diffs.length; i++){
                if(diffs[i] <= currentLevel) {
                    currentTime += times[i];
                } else {
                    int k = diffs[i] - currentLevel;
                    
                    if(i == 0) {
                        currentTime += (long) times[i] * k + times[i];
                    } else {
                        currentTime += k * ((long) times[i] + times[i - 1]) + times[i];
                    }
                }
                
                if(currentTime > limit) {
                    break;
                }
            }

            if(currentTime > limit) {
                left = currentLevel + 1;
            } else {
                answer = currentLevel;
                right = currentLevel - 1;
            }
        }
        
        return answer;
    }
}
