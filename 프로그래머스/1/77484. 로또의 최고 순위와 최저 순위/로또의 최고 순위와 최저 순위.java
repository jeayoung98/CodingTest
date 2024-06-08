import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[]{7, 7};
        // 당첨 번호를 저장할 HashSet 생성
        Set<Integer> set = new HashSet<>();
        for (int num : win_nums) {
            set.add(num);
        }

        // 당첨 번호와 0의 개수
        for (int i : lottos) {
            if (set.contains(i)) {
                answer[0]--; // 최고 순위 증가
                answer[1]--; // 최저 순위 증가
            }
            if (i == 0) {
                answer[0]--; // 0의 개수만큼 최고 순위 감소
            }
        }

        // 순위가 7인 경우 6
        answer[1] = answer[1] == 7 ? 6 : answer[1];
        answer[0] = answer[0] == 7 ? 6 : answer[0];
        
        return answer;
    }
}