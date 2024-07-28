import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            index.add(i);
        }

        int result = 0;
        // 모든 던전 순서 순열을 생성
        do {
            int currentFatigue = k;
            int count = 0;
            for (int i : index) {
                int[] dungeon = dungeons[i];
                if (currentFatigue >= dungeon[0]) { // 최소 필요 피로도 검사
                    currentFatigue -= dungeon[1]; // 피로도 소모
                    count++;
                } else {
                    break;
                }
            }
            result = Math.max(result, count);
        } while (nextPermutation(index));

        return result;
    }
    // 순열을 생성하는 함수
    private boolean nextPermutation(List<Integer> list) {
        int k = list.size() - 2;
        while (k >= 0 && list.get(k) >= list.get(k + 1)) {
            k--;
        }
        if (k == -1) return false;

        int l = list.size() - 1;
        while (list.get(k) >= list.get(l)) {
            l--;
        }

        Collections.swap(list, k, l);
        Collections.reverse(list.subList(k + 1, list.size()));
        return true;
    }
}