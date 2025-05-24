import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt((int[] o) -> o[1]));

        int lastEnd = 0;
        
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= lastEnd) {
                answer++;
                lastEnd = end;
            }
        }

        return answer;
    }
}
