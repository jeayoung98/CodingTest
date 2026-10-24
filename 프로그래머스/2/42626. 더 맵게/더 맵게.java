import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            int a = pq.poll();
            
            if(a >= K) break;
            if(pq.isEmpty()) return -1;
            int b = pq.poll();
            
            pq.add(a + b * 2);
            answer++;
        }
        return answer;
    }
}