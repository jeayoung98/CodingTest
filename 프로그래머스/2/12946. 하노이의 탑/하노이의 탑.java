import java.util.*;

class Solution {
    public List<List<Integer>> solution(int n) {
        List<List<Integer>> answer = new ArrayList<>();
        move(n, 1, 3, 2, answer);
        return answer;
    }

    public void move(int n, int start, int end, int temp, List<List<Integer>> answer) {
        if (n == 1) {
            answer.add(Arrays.asList(start, end));
            return;
        }

        move(n - 1, start, temp, end, answer);
        answer.add(Arrays.asList(start, end));
        move(n - 1, temp, end, start, answer);
    }
}