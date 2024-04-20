import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        if(arr.length == 1) return new int[] {-1};
        int min = min(arr);
        int index = 0;
        for(int i : arr) {
            if(i != min) {
                answer[index] = i;
                index++;
            }
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