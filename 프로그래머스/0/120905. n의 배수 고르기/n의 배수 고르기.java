import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = new int[numlist.length];
        int count = 0;
        for(int i = 0 , j = 0;i<numlist.length;i++){
            if(numlist[i]%n==0){
                answer[j]=numlist[i];
                j++;
                count++;
            }        
        }answer = Arrays.copyOfRange(answer,0,count);
        return answer;
    }    
        
    }
