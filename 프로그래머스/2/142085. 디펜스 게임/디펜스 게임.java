import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(enemy.length <= k) return enemy.length;
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++){
            queue.add(enemy[i]);
            if(queue.size() > k) n -= queue.poll();
            if(n < 0) break;
            answer++;
        }
        
        return answer;
    }
}