import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        int[] score1 = Arrays.stream(score)
                                .filter(value -> value <= k)
                                .toArray();
        
        Arrays.sort(score1);
        for (int i = score1.length - m; i >= 0; i -= m) {
            try{
                answer += score1[i] * m;
            }catch(IndexOutOfBoundsException e){
            }
        }
        return answer;
    }
}