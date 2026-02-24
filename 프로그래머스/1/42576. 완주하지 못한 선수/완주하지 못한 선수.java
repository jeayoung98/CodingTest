import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Queue<String> pq = new PriorityQueue<>(Arrays.asList(participant));
        Queue<String> cq = new PriorityQueue<>(Arrays.asList(completion));
        while(!cq.isEmpty()){
            if(pq.peek().equals(cq.peek())){
                pq.poll();
                cq.poll();
            }else {
                answer = pq.poll();
                break;
            }
        }
        if(!pq.isEmpty() && cq.isEmpty()) answer = pq.poll();
        
        return answer;
    }
}