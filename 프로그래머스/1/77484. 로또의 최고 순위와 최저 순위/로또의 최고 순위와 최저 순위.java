import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : win_nums) {
            set.add(num);
        }
        
        for(int i : lottos){
            if(set.contains(i)) count++;
            if(i == 0) zero++;
        }
        
        answer[1] = 7 - count == 7 ? 6 : 7 - count;
        answer[0] = 7 - count - zero == 7 ? 6 : 7 - count - zero;
        return answer;
    }
}