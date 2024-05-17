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
        // 정렬 Comparator 생성
        Comparator<int[]> sortArr = (a, b) -> a[map.get(sort_by)] - b[map.get(sort_by)];
        
        // 정렬 수행
        Arrays.sort(data, sortArr);
        
        // 필터링 수행하여 조건에 맞는 행만 선택
        return Arrays.stream(data)
            .filter(a -> a[map.get(ext)] < val_ext)
            .toArray(int[][]::new);
    }
}
