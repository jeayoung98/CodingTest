import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = createMap(str1);
        Map<String, Integer> map2 = createMap(str2);
        
        // 교집합
        int intersection = 0;
        // 합집합
        int union = 0;
        
        // 합집합과 교집합 계산
        Set<String> set = new HashSet<>(map1.keySet());
        set.addAll(map2.keySet());
        for (String key : set) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        
        // 자카드 유사도 계산
        double jaccard = (union == 0) ? 1 : (double) intersection / union;
        return (int) (jaccard * 65536);
    }
    
    private static Map<String, Integer> createMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String str1 = "" + c1 + c2;
                map.put(str1, map.getOrDefault(str1, 0) + 1);
            }
        }
        return map;
    }
}