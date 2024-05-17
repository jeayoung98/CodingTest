import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            int doll = pickDoll(board, i);
            answer += processMove(stack, doll);
        }
        
        return answer;
    }

    // 보드에서 move에 해당하는 열의 가장 위에 있는 인형을 뽑아 반환
    private int pickDoll(int[][] board, int move) {
        for (int j = 0; j < board.length; j++) {
            if (board[j][move - 1] != 0) {
                int doll = board[j][move - 1];
                board[j][move - 1] = 0; // 뽑은 인형 자리를 0으로 만듦
                return doll;
            }
        }
        return 0;
    }

    // 뽑은 인형을 스택에 쌓고, 스택 업데이트
    private int processMove(Stack<Integer> stack, int doll) {
        int count = 0;
        if (doll != 0) { // 뽑은 인형이 있을 때만 처리
            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                count = 2;
            } else {
                stack.push(doll); // 다른 인형일 경우 스택에 추가
            }
        }
        return count;
    }
}
