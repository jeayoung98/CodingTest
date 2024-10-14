import java.util.*;

public class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        return bfs(x, y, n);
    }

    private int bfs(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];  
        queue.offer(x);
        visited[x] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                int[] results = {current + n, current * 2, current * 3};
                for (int result : results) {
                    if (result == y) {
                        return count + 1;
                    }
                    if (result <= y && !visited[result]) {
                        queue.offer(result);
                        visited[result] = true;
                    }
                }
            }
            count++; 
        }

        return -1;
    }
}
