import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int num = -1;
        for(int i = 0; i < arr.length; i++){
            if(num != arr[i]){
                list.add(arr[i]);
                num = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}