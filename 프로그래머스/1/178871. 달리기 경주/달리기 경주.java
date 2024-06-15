import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 말, 인덱스
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        List<String> horseList = new ArrayList<>(Arrays.asList(players));

        for (String horse : callings) {
            Integer index = map.get(horse);
            String frontHorse = horseList.get(index - 1);

            // 말의 위치를 서로 바꿈
            horseList.set(index - 1, horse);
            horseList.set(index, frontHorse);

            // 인덱스 맵 업데이트
            map.put(horse, index - 1);
            map.put(frontHorse, index);
        }

        return horseList.toArray(new String[0]);
    }
}