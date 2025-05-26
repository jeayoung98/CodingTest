import java.util.*;

class Solution {
    Map<Integer, int[]> currentPoint = new HashMap<>();
    Map<Integer, Queue<Integer>> goal = new HashMap<>();
    int[][] currentGoal;

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        currentGoal = new int[routes.length][2];
        
        for(int i = 0; i < routes.length; i++){
            currentPoint.put(i, new int[]{points[routes[i][0]-1][0], points[routes[i][0]-1][1]});
            goal.put(i, new LinkedList<>());
            for(int j = 1; j < routes[i].length; j++){
                goal.get(i).add(routes[i][j]);
            }
            
            if(!goal.get(i).isEmpty()){
                int[] firstGoal = points[goal.get(i).poll() - 1];
                currentGoal[i][0] = firstGoal[0];
                currentGoal[i][1] = firstGoal[1];
            }
        }
        
        answer += crash();
        
        while(!isDone()){
            move(points);
            answer += crash();
        }
        
        return answer;
    }
    
    public void move(int[][] points){
        List<Integer> arrive = new ArrayList<>();
        
        for(int i : currentPoint.keySet()){
            int[] current = currentPoint.get(i);
            int[] target = currentGoal[i];
            if(current[0] == target[0] && current[1] == target[1]){
                Queue<Integer> queue = goal.get(i);
                if(!queue.isEmpty()){
                    int[] nextGoal = points[queue.poll() - 1];
                    currentGoal[i][0] = nextGoal[0];
                    currentGoal[i][1] = nextGoal[1];
                } else {
                    arrive.add(i);
                    continue;
                }
            }
            
            if(current[0] != currentGoal[i][0]){
                int diff = currentGoal[i][0] - current[0];
                current[0] += diff / Math.abs(diff);
            }
            else if(current[1] != currentGoal[i][1]){
                int diff = currentGoal[i][1] - current[1];
                current[1] += diff / Math.abs(diff);
            }
            
            currentPoint.put(i, current);
        }
        
        for(int robotId : arrive){
            currentPoint.remove(robotId);
        }
    }
    
    public int crash(){
        Map<String, Integer> map = new HashMap<>();
        
        for(int[] pos : currentPoint.values()){
            String key = pos[0] + "," + pos[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int result = 0;
        for(int count : map.values()){
            if(count >= 2){
                result++;
            }
        }
        return result;
    }

    public boolean isDone(){
        return currentPoint.isEmpty();
    }
}
