import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            queue.add(w);
        }
        
        for(int i = 0; i < n; i++){
            if(queue.peek() != 0){
                queue.add(queue.poll() - 1);
            }
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            answer += current * current;
        }
        return answer;
    }
}