import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        char[] c = binary.toCharArray();
        for(char c1 : c){
            if(c1 == '1')answer++;
        }
        return answer;
    }
}