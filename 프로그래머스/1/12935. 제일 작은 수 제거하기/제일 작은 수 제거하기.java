import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        int min = min(arr);
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            if(i != min) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public int min(int[] arr) {
        int min = arr[0];
        for(int i : arr) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }
}