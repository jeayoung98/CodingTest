import java.util.*;

class Solution {
    int k, n;
    int[][] cost;
    int min = Integer.MAX_VALUE;
    int max;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        this.max = n - k + 1;

        // 유형별 요청
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < k; i++){
          list.add(new ArrayList<>());  
        }
        for (int[] r : reqs){
          list.get(r[2] - 1).add(new int[]{r[0], r[1]});  
        }

        cost = new int[k][max + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= max; j++) {
                cost[i][j] = simulate(list.get(i), j);
            }
        }

        backtrack(0, n, new int[k]);
        return min;
    }

    public int simulate(List<int[]> list, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++){
            pq.add(0);
        }

        int result = 0;
        for (int[] req : list) {
            int a = req[0], b = req[1];
            int current = pq.poll();
            int start = Math.max(current, a);
            result += start - a;
            pq.add(start + b);
        }
        return result;
    }

    public void backtrack(int num, int remain, int[] mentor) {
        if (num == k - 1) {
            if (remain < 1 || remain > max) return;
            mentor[num] = remain;
            int total = 0;
            for (int i = 0; i < k; i++){
               total += cost[i][mentor[i]];
            }
            min = Math.min(min, total);
            return;
        }
        int need = k - num - 1;
        for (int i = 1; i <= Math.min(max, remain - need); i++) {
            mentor[num] = i;
            backtrack(num + 1, remain - i, mentor);
        }
    }
}