import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] arr = new long[n + 1];
        arr[0] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = arr[i - 1] * i;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }        
        k--;
        for(int i = 0; i < n; i++){
            long num = arr[n - 1 - i];
            int index = (int)(k / num);
            k = k % num;
            answer[i] = list.get(index);
            list.remove(index);
        }

        return answer;
    }
}