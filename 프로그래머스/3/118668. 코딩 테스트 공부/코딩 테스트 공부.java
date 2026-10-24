
import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dist = new int[maxAlp + 1][maxCop + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {소요 시간, 알고력, 코딩력}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[alp][cop] = 0;
        pq.offer(new int[]{0, alp, cop});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int time = cur[0];
            int a = cur[1];
            int c = cur[2];

            if (time > dist[a][c]) continue;

            // 목표 도달
            if (a == maxAlp && c == maxCop) {
                return time;
            }

            // 1. 알고리즘 공부
            if (a < maxAlp && dist[a + 1][c] > time + 1) {
                dist[a + 1][c] = time + 1;
                pq.offer(new int[]{time + 1, a + 1, c});
            }

            // 2. 코딩 공부
            if (c < maxCop && dist[a][c + 1] > time + 1) {
                dist[a][c + 1] = time + 1;
                pq.offer(new int[]{time + 1, a, c + 1});
            }

            // 3. 문제 풀이
            for (int[] p : problems) {
                int reqAlp = p[0];
                int reqCop = p[1];

                int rwdAlp = p[2];
                int rwdCop = p[3];
                int cost = p[4];

                if (a < reqAlp || c < reqCop) continue;

                int na = Math.min(maxAlp, a + rwdAlp);
                int nc = Math.min(maxCop, c + rwdCop);

                if (dist[na][nc] > time + cost) {
                    dist[na][nc] = time + cost;
                    pq.offer(new int[]{time + cost, na, nc});
                }
            }
        }

        return -1;
    }
}
