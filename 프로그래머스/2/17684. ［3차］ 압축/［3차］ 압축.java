import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String,Integer> map = new HashMap<>();
        for (int i = 65; i < 91; i++) {
            map.put(((char)i)+"",i-64);
        }
        
        Deque<String> deque = new ArrayDeque<>();      
        
        for(int i = 0; i < msg.length(); i++){
            deque.add(msg.charAt(i)+"");
        }
        List<Integer> list = new ArrayList<>();
        int count = 27;
        while(!deque.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append(deque.removeFirst());
            // map에 없는 단어 찾기
            while (!deque.isEmpty() && map.containsKey(sb.toString() + deque.peekFirst())) {
                sb.append(deque.removeFirst());
            }

            // 찾은 문자 번호 추가
            list.add(map.get(sb.toString()));

            // 새로운 문자 추가
            if (!deque.isEmpty()) {
                String newStr = sb.toString() + deque.peekFirst();
                if (!map.containsKey(newStr)) {
                    map.put(newStr, count++);
                }
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}