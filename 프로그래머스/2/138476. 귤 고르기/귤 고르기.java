import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        
        int[] arr = Arrays.stream(tangerine).boxed().sorted((a,b) -> map.get(b) - map.get(a)).mapToInt(i -> i).toArray();
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < k; i++){
            set.add(arr[i]);
        }
        return set.size();
    }
}