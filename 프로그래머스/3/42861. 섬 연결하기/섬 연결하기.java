import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs,(a,b) -> a[2] - b[2]);
        
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            if(union(a,b)) answer += cost;
        }
        return answer;
    }
    
    public int find(int a){
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        
        parent[pb] = pa;
        
        return true;
    }
}