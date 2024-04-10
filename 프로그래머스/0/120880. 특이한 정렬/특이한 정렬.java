import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            answer[i] = Math.abs(numlist[i] - n);
        }

        // 거리에 따라 numlist의 순서를 정렬
        for (int i = 0; i < numlist.length - 1; i++) {
            for (int j = i + 1; j < numlist.length; j++) {
                if (answer[i] > answer[j] || (answer[i] == answer[j] && numlist[i] < numlist[j])) {
                    // 거리가 작은 순서대로 또는 거리가 같으면 큰 순서대로 정렬
                    int temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;

                    int tempNum = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = tempNum;
                }
            }
        }
        return numlist;
    }
}