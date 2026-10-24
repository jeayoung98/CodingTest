import java.util.*;

class Solution {
    class Edge{
        int to, cost;
        
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    List<Edge>[] list;
    int N;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        N = n;
        list = new List[n + 1];
        
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < fares.length; i++){
            int x = fares[i][0];
            int y = fares[i][1];
            int c = fares[i][2];
            
            list[x].add(new Edge(y, c));
            list[y].add(new Edge(x, c));
        }
        
        int[] sl = dijkstra(s);
        int[] al = dijkstra(a);
        int[] bl = dijkstra(b);
        
        for(int i = 1; i <= N; i++){
            answer = Math.min(answer, sl[i] + al[i] + bl[i]);
        }
        return answer;
    }
    
    public int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int to = current.to;
            int cost = current.cost;
            
            if(dist[to] < cost) continue;
            
            for(Edge edge : list[to]){
                int nc = cost + edge.cost;
                if(nc < dist[edge.to]){
                    dist[edge.to] = nc;
                    pq.add(new Edge(edge.to, nc));
                }
            }
        }
        return dist;
    }
}