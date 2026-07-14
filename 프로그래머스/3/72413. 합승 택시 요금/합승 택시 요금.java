import java.util.*;

class Solution {
    class Edge{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    List<Edge>[] edgeList;
    int n;
    final int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 다익스트라 3번 하면 될듯 ?
        // 666600 -> 다익스트라 3개
        // 완탐 ? -> 20000
        // 686600 가능할듯 ?
        int answer = Integer.MAX_VALUE;
        this.n = n;
        edgeList = new List[n + 1];
        
        for(int i = 0; i < n + 1; i++){
            edgeList[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];
            
            edgeList[x].add(new Edge(y, cost));
            edgeList[y].add(new Edge(x, cost));
        }
        
        // 현재 위치 s, 집 위치 a, b
        int[] sd = dijkstra(s);
        int[] ad = dijkstra(a);
        int[] bd = dijkstra(b);

        for(int i = 1; i < n + 1; i++){
            int sum = sd[i] + ad[i] + bd[i];
            answer = Math.min(sum, answer);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        pq.add(new Edge(start, 0));
        
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int now = current.to;
            int currentC = current.cost;
            
            if(dist[now] < currentC) continue;
            
            for(Edge edge : edgeList[now]){
                int nextC = currentC + edge.cost;
                if(nextC < dist[edge.to]){
                    dist[edge.to] = nextC;
                    pq.add(new Edge(edge.to, nextC));
                }
            }
        }
        return dist;
    }
    
    public void fillINF(int[] dist){
        Arrays.fill(dist,INF);
    }
}