import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list =  Arrays.stream(progresses).boxed().collect(Collectors.toList());
        List<Integer> speedList = Arrays.stream(speeds).boxed().collect(Collectors.toList());
        List<Integer> count = new ArrayList<>();
        while(list.size() > 0){
            Deque<Integer> deque = new ArrayDeque<>();
            // speed 를 프로그레스에 더해줌
            for(int i = 0; i < list.size(); i++){
                list.set(i,list.get(i) + speedList.get(i));
            }

            // 첫번째가 진행도 100이상인지
            while(!list.isEmpty() && list.get(0) >= 100){
                if(list.get(0) >= 100){
                    // 100이상이면 큐에 넣어주고 리스트에서 첫번째 삭제
                    deque.add(list.get(0));
                    list.remove(0);
                    speedList.remove(0);
                }
            }
            if(deque.size() != 0) count.add(deque.size());
        }


        return count.stream().mapToInt(Integer::intValue).toArray();
    }
}