import java.util.*;
class Solution {
    static boolean [] check;
    public int[] solution(long begin, long end) {
        int start = (int) begin;
        int[] answer = new int[(int)end - start + 1];
        Arrays.fill(answer, 1);
        for(int i = start; i <= (int)end; i++){ 
            answer[i - start] = cal(i);
        }
        if(start == 1) answer[0] = 0;
        return answer;
    }
    public static int cal(int num){
        int max = 1;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                max = i;
                if(num / i <= 10000000)
                return num / i;
            }
        }
        return max;
    }
}