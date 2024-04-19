import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        for(int i : arr){
            if(i % divisor == 0){
                result.add(i);
            }
        }
        if(result.isEmpty()){
            result.add(-1);
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}