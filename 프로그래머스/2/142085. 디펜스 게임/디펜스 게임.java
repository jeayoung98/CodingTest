import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        int current = 0;
        for(int i = 0; i < enemy.length; i++){
            queue.add(enemy[i]);
            
            if(queue.size() > k) current += queue.poll();
            if(current > n) break;
            
            answer = i + 1;
        }
        return answer;
    }
}