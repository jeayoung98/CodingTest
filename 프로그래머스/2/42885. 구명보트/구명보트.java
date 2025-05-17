import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int max = people.length - 1;
        for(int i = 0; i <= max; i++){
            if(people[i] + people[max] > limit){
                i--;
            }
            max--;
            answer++;
        }
        return answer;
    }
}