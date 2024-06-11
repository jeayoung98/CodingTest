import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        for(int i = 1;i < n/2; i++){
            if(n % i == 0){
                int a = i;
                int b = n / i;
                if(brown == 2 * a + 2 * (b-2)) {
                    answer[0] = a;
                    answer[1] = b;
                }
            }
        }
        return answer;
    }
}