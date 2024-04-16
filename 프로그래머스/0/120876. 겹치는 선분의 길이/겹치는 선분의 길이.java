public class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int min = 0;
        int max = 0;
        for (int[] line : lines) {
            min = Math.min(min, line[0]);
            max = Math.max(max, line[1]);
        }
        for (int i = min; i <= max; i++) {
            int count = 0;
            for (int[] line : lines) {
                if (line[0] <= i && i < line[1]) {
                    count++;
                }
            }
            if (count > 1) {
                answer++;
            }
        }
        return answer;
    }
}