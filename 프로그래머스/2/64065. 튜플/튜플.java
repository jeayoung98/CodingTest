import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Set<Integer>> setList = new ArrayList<>();
        
        
        s = s.substring(2, s.length() - 2).replace("},{", "}-{" );
        String[] arr = s.split("}-\\{");
        
        
        for (String part : arr) {
            Set<Integer> set = new HashSet<>();
            String[] nums = part.split(",");
            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
            setList.add(set);
        }
        
        
        setList.sort(Comparator.comparingInt(Set::size));
        
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> lastUsed = new HashSet<>();
        
        
        for (Set<Integer> set : setList) {
            set.removeAll(lastUsed);  
            int foundNum = set.iterator().next();  
            result.add(foundNum); 
            lastUsed.add(foundNum);  
        }
        
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}