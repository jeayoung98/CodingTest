import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = -30_000;

        for (int[] route : routes) {
            if (route[0] > camera) {
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }
}
