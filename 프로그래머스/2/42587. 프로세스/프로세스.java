import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> prioritiesList = new ArrayList<>();
        for(int i = 0 ; i < priorities.length; i++){
            prioritiesList.add(priorities[i]);
        }
        
        Deque<List<Integer>> deque = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(priorities[i]);
            deque.add(list);
        }
        
        while(true){
            int max = deque.stream()
                        .max(Comparator.comparingInt(a -> a.get(1)))
                        .orElse(Arrays.asList(0, 0)).get(1);
            
            if(deque.getFirst().get(1) != max) {
                deque.add(deque.removeFirst());
            }
            else{
                answer++;
                List<Integer> i = deque.removeFirst();
                if(i.get(0) == location) break;
            }
            
        }
        
        
        return answer;
    }
}