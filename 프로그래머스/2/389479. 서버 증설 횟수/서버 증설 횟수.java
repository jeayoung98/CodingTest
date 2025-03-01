import java.util.*;

class Solution {
    int M,K,answer,time;
    Queue<Integer> queue = new PriorityQueue<>();
    public int solution(int[] players, int m, int k) {
        M = m;
        K = k;
        for(int i = 0; i < players.length; i++){
            int currentPlayer = players[i];
            endServer();
            addServer(currentPlayer);
            time++;
        }
        return answer;
    }
    
    public void addServer(int currentPlayer){
        if(currentPlayer >= (queue.size() + 1) * M){
            while(true){
                if(currentPlayer < (queue.size() + 1) * M){
                    break;
                } 
                queue.add(time + K);
                answer++;
            }
        }
    } 
    
    public void endServer(){
        while(!queue.isEmpty() && queue.peek() <= time){
            queue.poll();
        }
    }
}