import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        for(int num1 : lottos){
            for(int num2 : win_nums){
                if(num1 == num2) count++;
            }
        }
        
        int zero1 = 0;
        for(int num3 : lottos){
            if(num3 == 0) zero1++;
        }
        if(zero1 == 6){
            answer[0] = 1;
            answer[1] = 6;
        }
        else if (count == 0 && zero1 == 0){
            answer[0] = 6;
            answer[1] = 6;
        }
        else {
            answer[0] = 7-count-zero1;
            answer[1] = 7 - count;
        }
        return answer;
    }
}