import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        String[] arr = new String[3];
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0 ; i < files.length; i++){
            for(int j = 0 ; j < files[i].length(); j++){
                deque.add(files[i].charAt(j));
            }
            
        }
        System.out.println(deque);
        return answer;
    }
    
    // public void head(){
    //     while()
    // }
}