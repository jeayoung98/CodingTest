import java.util.*;

public class Solution {
    public int solution(String word) {
        int[] weights = new int[5];
        int length = weights.length;
        for(int i = 0; i < length; i++){
            weights[i] = 0;
            for(int j = 0; j < length - i ; j++){
                weights[i] += Math.pow(5,j);
            }
        }
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (ch == vowels[j]) {
                    answer += weights[i] * j;
                    break;
                }
            }
        }
        return answer + word.length();
    }
}