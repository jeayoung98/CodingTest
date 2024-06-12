import java.util.*;

class Solution {
    // 맵 초기화
    Map<String, Integer> map = new HashMap<>();
    {
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data)
            // 정렬
            .sorted(Comparator.comparingInt(a -> a[map.get(sort_by)]))
            // 조건에 맞는 행
            .filter(a -> a[map.get(ext)] < val_ext)
            .toArray(int[][]::new);
    }
}
