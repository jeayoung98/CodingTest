import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = 0;
        int y = 1;
        while(true){
            boolean isTrue = false;
            int x = arr[arr.length-1];
            x *= y;
            for(int i = 0; i < arr.length-1;i++){
                isTrue = x % arr[i] == 0;
                if(isTrue == false) break;
            }
            if(isTrue) {
                answer = x;
                break;
            }
            y++;
        }
        
        return answer;
    }   
}