import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1L;
        long right = (long) times[0] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long result = 0L;

            for (int i : times) {
                result += mid / i;
            }

            if (result >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
