import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] room = new int[n][m];
        int[] current = new int[2];
        int direction = 0; // 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
        current[0] = sc.nextInt();
        current[1] = sc.nextInt();
        direction = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                room[i][j] = sc.nextInt();
            }
        }

        int cleanCount = 0;
        boolean isRunning = true;

        while (isRunning) {
            // 현재 위치를 청소
            if (room[current[0]][current[1]] == 0) {
                room[current[0]][current[1]] = 2; // 청소한 곳은 2로 표시
                cleanCount++;
            }

            boolean foundNext = false;

            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4; // 왼쪽으로 회전
                int[] next = forward(current, direction);

                if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m && room[next[0]][next[1]] == 0) {
                    current = next;
                    foundNext = true;
                    break;
                }
            }

            if (!foundNext) { // 4방향 모두 청소되었거나 벽인 경우
                int[] back = backward(current, direction);
                if (back[0] >= 0 && back[0] < n && back[1] >= 0 && back[1] < m && room[back[0]][back[1]] != 1) {
                    current = back; // 후진
                } else {
                    isRunning = false; // 후진할 곳이 없으면 작동 중지
                }
            }
        }

        System.out.println(cleanCount);
    }

    // 전진
    public static int[] forward(int[] current, int direction) {
        int[] next = current.clone();
        switch (direction) {
            case 0: next[0]--; break; // 북쪽
            case 1: next[1]++; break; // 동쪽
            case 2: next[0]++; break; // 남쪽
            case 3: next[1]--; break; // 서쪽
        }
        return next;
    }

    // 후진
    public static int[] backward(int[] current, int direction) {
        int[] next = current.clone();
        switch (direction) {
            case 0: next[0]++; break; // 북쪽 -> 남쪽
            case 1: next[1]--; break; // 동쪽 -> 서쪽
            case 2: next[0]--; break; // 남쪽 -> 북쪽
            case 3: next[1]++; break; // 서쪽 -> 동쪽
        }
        return next;
    }
}
