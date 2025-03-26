import java.util.*;

class Solution {
    int N;
    int[] arr;
    int answer;
    public int solution(int n) {
        N = n;
        arr = new int[N];
        dfs(0);
        return answer;
    }
    
    public void dfs(int depth){
        if(depth == N){
            answer++;
            return;
        }
        
        for(int i = 0; i < N; i++){
            arr[depth] = i;
            if(isSafe(depth)){
                dfs(depth + 1);
            }
        }
    }
    
    public boolean isSafe(int depth){
        for(int i = 0; i < depth; i++){
            if(arr[i] == arr[depth] || Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])){
                return false;
            }
        }
        return true;
    }
}