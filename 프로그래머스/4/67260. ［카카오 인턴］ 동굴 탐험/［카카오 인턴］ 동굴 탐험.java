import java.util.*;

class Solution {
    List<Integer>[] list;
    int[] first, waiting;
    int n;

    public boolean solution(int n, int[][] path, int[][] order) {
        list = new ArrayList[n];
        this.n = n;

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] p : path) {
            int a = p[0];
            int b = p[1];

            list[a].add(b);
            list[b].add(a);
        }

        // 먼저 방문해야 하는 방
        first = new int[n];
        Arrays.fill(first, -1);

        for (int[] o : order) {
            int a = o[0];
            int b = o[1];

            first[b] = a;
        }

        // 선행조건 기다리고 있는 방
        waiting = new int[n];
        Arrays.fill(waiting, -1);

        if(first[0] != -1) return false;
        return bfs() == n;
    }
    
    public int bfs(){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[0] = true;
        queue.add(0);

        int result = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : list[current]) {
                if (visited[next]) {
                    continue;
                }

                int before = first[next];

                // 선행 방을 아직 방문하지 않음
                if (before != -1 && !visited[before]) {
                    waiting[before] = next;
                    continue;
                }

                visited[next] = true;
                result++;
                queue.add(next);

                // 현재 방을 기다리던 방이 있으면 방문 가능
                if (waiting[next] != -1) {
                    int room = waiting[next];

                    if (!visited[room]) {
                        visited[room] = true;
                        result++;
                        queue.add(room);
                    }
                }
            }
        }
        
        return result;
    }
}