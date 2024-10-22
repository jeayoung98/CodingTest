import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] s = numbers.split("");
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[s.length];
        
        for (int i = 1; i <= s.length; i++) {
            dfs(s, "", visited, i, set);
        }
        System.out.println(set);
        return set.size();
    }
    
    public boolean isPrime(String str){
        boolean result = true;
        int n = Integer.parseInt(str);
        if(n == 0 || n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n);i++){
            if(n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    public void dfs(String[] s, String current, boolean[] visited, int depth, Set<Integer> set) {
        if (current.length() == depth && isPrime(current)) {
            set.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(s, current + s[i], visited, depth, set);
                visited[i] = false;
            }
        }
    }
}