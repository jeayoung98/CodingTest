import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] legend = new int[k];
        int[] answer = new int[score.length];
        if(k >= score.length){
            Arrays.fill(legend,3000);
            for(int i = 0; i < score.length; i++){
                legend[i] = score[i];
                Arrays.sort(legend);
                answer[i] = legend[0];
            }
        }else{
            int min = 3000;
        for(int i = 0; i < k; i++){
            min = Math.min(score[i],min);
            answer[i] = min;
            legend[i] = score[i];
        }
        Arrays.sort(legend);
        for(int i = k; i < score.length; i++){
            if(legend[0] < score[i]){
                legend[0] = score[i];
                Arrays.sort(legend);
            }
            answer[i] = legend[0];
        }
        }
        
        return answer;
    }
}