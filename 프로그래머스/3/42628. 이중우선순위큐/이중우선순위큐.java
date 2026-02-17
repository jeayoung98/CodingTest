import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            if (op.charAt(0) == 'I') {
                int num = Integer.parseInt(op.substring(2));
                map.put(num, map.getOrDefault(num, 0) + 1);

            }else{
                if(map.isEmpty()) continue;
                if (op.startsWith("D 1")) remove(map.lastKey(), map);
                else remove(map.firstKey(), map);  
            }
                    
        }
        if (map.isEmpty()) return new int[]{0,0};

        return new int[]{map.lastKey(), map.firstKey()};
    }

    public void remove(int key, TreeMap<Integer,Integer> map) {
        int cnt = map.get(key);
        if (cnt == 1) map.remove(key);
        else map.put(key, cnt - 1);
    }
}
