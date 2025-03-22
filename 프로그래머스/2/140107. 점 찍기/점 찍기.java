public class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int maxA = d / k;
        for (int a = 0; a <= maxA; a++) {
            long remain = (long)d * d - (long)a * a * k * k;
            int maxB = (int)(Math.sqrt(remain) / k);
            answer += (maxB + 1);
        }
        return answer;
    }
}