import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        Map<Integer, int[]> pos = new HashMap<>();
        int[] height = new int[w];

        for (int i = 1; i <= n; i++) {
            int row = (i - 1) / w;
            int offset = (i - 1) % w;
            int col = (row % 2 == 0) ? offset : (w - 1 - offset);

            int level = height[col];
            pos.put(i, new int[]{col, level});
            height[col]++;
        }

        int[] p = pos.get(num);
        int col = p[0], level = p[1];

        return height[col] - level;
    }
}
