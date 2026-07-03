import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int cut = 0; cut < wires.length; cut++) {
            boolean[] connected = new boolean[n + 1];

            // 끊은 전선의 한쪽에서 시작
            int start = wires[cut][0];
            connected[start] = true;

            boolean changed = true;

            while (changed) {
                changed = false;

                for (int i = 0; i < wires.length; i++) {
                    if (i == cut) continue; // 이 전선은 끊은 상태

                    int a = wires[i][0];
                    int b = wires[i][1];

                    if (connected[a] && !connected[b]) {
                        connected[b] = true;
                        changed = true;
                    } else if (connected[b] && !connected[a]) {
                        connected[a] = true;
                        changed = true;
                    }
                }
            }

            int count = 0;

            for (int i = 1; i <= n; i++) {
                if (connected[i]) {
                    count++;
                }
            }

            int other = n - count;
            int diff = Math.abs(count - other);

            answer = Math.min(answer, diff);
        }

        return answer;
    }
}