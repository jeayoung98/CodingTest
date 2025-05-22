import java.util.*;

class Solution {
    int n;
    int[][] q;
    int[] ans;
    int result = 0;
    int[] arr = new int[5];

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        dfs(1, 0);
        return result;
    }
    

    public void dfs(int start, int depth) {
        if (depth == 5) {
            if (isValid()) {
                result++;
            }
            return;
        }
        for (int i = start; i <= n - (5 - depth) + 1; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public boolean isValid() {
        boolean[] current = new boolean[n + 1];
        for (int i : arr) {
            current[i] = true;
        }
        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int j : q[i]) {
                if (current[j]) {
                    count++;
                }
            }
            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }
}