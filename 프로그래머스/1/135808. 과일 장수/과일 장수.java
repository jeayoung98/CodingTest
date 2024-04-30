import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

//         int[] score1 = Arrays.stream(score)
//                                 .filter(value -> value <= k)
//                                 .toArray();
        
        Arrays.sort(score);
        for (int i = score.length - m; i >= 0; i -= m) {
            try{
                answer += score[i] * m;
            }catch(IndexOutOfBoundsException e){
            }
        }
        return answer;
    }
}