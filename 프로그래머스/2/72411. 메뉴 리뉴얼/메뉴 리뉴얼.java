import java.util.*;

class Solution {
    char[] name = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        for (int i : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                if (order.length() < i) continue;
                List<String> list = new ArrayList<>();
                menu(order, 0, i, new StringBuilder(), list);
                for (String s : list) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
            
            int maxCount = 0;
            for (int count : map.values()) {
                if (count >= 2 && count > maxCount) {
                    maxCount = count;
                }
            }
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    answer.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void menu(String order, int start, int size, 
                                     StringBuilder sb, List<String> list) {
        if (sb.length() == size) {
            list.add(sb.toString());
            return;
        }
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            menu(order, i + 1, size, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
