import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];

        for (int i = 0; i < n; i++) {
            binary1[i] = binary(arr1[i], n);
            binary2[i] = binary(arr2[i], n);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binary1[i].charAt(j) == '1' || binary2[i].charAt(j) == '1') {
                    line.append("#");
                } else {
                    line.append(" ");
                }
            }
            answer[i] = line.toString();
        }
        return answer;
    }
    
    public String binary(int num, int n) {
        StringBuilder result = new StringBuilder(Integer.toBinaryString(num));
        while (result.length() < n) {
            result.insert(0, '0');
        }
        return result.toString();
    }
}