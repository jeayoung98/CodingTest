import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 1) union(i,j);
                
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(find(i));
        }
        return set.size();
    }
    
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        parent[b] = a;
    }
}