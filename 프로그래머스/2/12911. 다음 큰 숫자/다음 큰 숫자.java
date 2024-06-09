import java.util.*;

class Solution {
    public int solution(int n) {
        int targetCount = countOnes(Integer.toBinaryString(n));  // 원래 숫자 n의 1의 개수
        int current = n;
        while (true) {
            current++;
            if (countOnes(Integer.toBinaryString(current)) == targetCount) {  // 1의 개수같은지 확인
                break;
            }
        }
        return current;
    }

    private int countOnes(String binary) {
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
