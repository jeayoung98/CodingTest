import java.util.*;

class Solution {
    public class Node {
        int index;
        int cost;
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int x = r[0] - 1;
            int y = r[1] - 1;
            int cost = r[2];
            list.get(x).add(new Node(y, cost));
            list.get(y).add(new Node(x, cost));
        }
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        bfs(N, list, distance);
        
        for (int d : distance) {
            if (d <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int N, List<List<Node>> list,int[] distance){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = false;
            
            for (Node next : list.get(current)) {
                if (distance[next.index] > distance[current] + next.cost) {
                    distance[next.index] = distance[current] + next.cost;
                    if (!visited[next.index]) {
                        queue.offer(next.index);
                        visited[next.index] = true;
                    }
                }
            }
        }
    }
    
    
}
