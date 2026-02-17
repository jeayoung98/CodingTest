import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int q = s / n;
        int r = s % n;

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = q;
        for (int i = n - 1; i >= n - r; i--) answer[i] = q + 1;

        return answer;
    }
}
