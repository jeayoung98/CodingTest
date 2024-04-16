import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            answer.add(i);
        }
        
        Iterator<Integer> iterator = answer.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            if(num % 2 == 0){
                iterator.remove();
            }
        }
        return answer;
    }
}