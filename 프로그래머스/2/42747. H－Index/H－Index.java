import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;

        int[] arr = Arrays.stream(citations).boxed().sorted((a,b)-> b-a).mapToInt(i-> i).toArray();

        if(arr[0]==0){
            answer=0;
        }
        for(int i=0;i<citations.length;i++){
            if(arr[i]>=i+1){
                answer=i+1;
            }else{
                break;
            }
        }
        return answer;
    }
}