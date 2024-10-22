import java.util.*;

public class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        String answer = sb.toString();
        return answer.startsWith("0") ? "0" : answer;
    }
}
