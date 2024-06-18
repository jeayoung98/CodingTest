import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0,0};
        Stack<String> stack = new Stack<>();
        String lastWord = "";
        int i = 0;
        
        while(true){
            if(i >= words.length) break;
            if(i == words.length-1){
                if(!lastWord.endsWith(words[i].charAt(0)+"") || stack.contains(words[i])) {
                    answer = new int[]{i % n + 1,i / n +1};
                    break;
                }
            }
            else if(i != 0){
                if(!lastWord.endsWith(words[i].charAt(0)+"") || stack.contains(words[i])) {
                    answer = new int[]{i % n + 1,i / n +1};
                    break;
                }
            }
            lastWord = words[i];
            stack.push(words[i]);
            i++;
        }

        return answer;
    }
}