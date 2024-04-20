import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int money = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            if(money + d[i] > budget) break;
            money += d[i];
            answer++;
        }
        return answer;
    }
}