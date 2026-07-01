import java.util.*;

class Solution {
    List<Integer>[] edgeList;
    int[] max;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        edgeList = new List[n + 1];
        max = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int[] current = edge[i];
            edgeList[current[0]].add(current[1]);
            edgeList[current[1]].add(current[0]);
        }


        bfs(n);

        
        for(int i = n; i >= 1; i--){
            if(max[i] != 0) {
                answer = max[i];
                break;
            }
        }

        return answer; 
    }

    public void bfs(int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int dis = current[1];

            for (int j : edgeList[num]) {
                if (!visited[j]) {
                    max[dis + 1]++;
                    queue.add(new int[]{j, dis + 1});
                    visited[j] = true;
                }
            }
        }
    }
}