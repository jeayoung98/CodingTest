import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryNum = Integer.toBinaryString(n);
        int oneCount = Integer.bitCount(n);
        int current = n;
        while(true){
            current++;
            if(Integer.bitCount(current) == oneCount){
                answer = current;
                break;
            }
        }
        return answer;
    }
}