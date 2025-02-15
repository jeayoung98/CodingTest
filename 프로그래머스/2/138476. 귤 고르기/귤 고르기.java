import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        int[] sortedArr = Arrays.stream(tangerine)
                                .boxed()
                                .sorted((a,b)-> map.get(b) - map.get(a))
                                .mapToInt(i -> i)
                                .toArray();
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < k; i++){
            set.add(sortedArr[i]);
        }
        return set.size();
    }
}