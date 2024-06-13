import java.util.*;

public class Main {
    private static int[][] board; // 게임 보드. 사과와 뱀의 위치를 저장.
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 보드의 크기
        int K = scanner.nextInt(); // 사과의 개수
        board = new int[N + 1][N + 1];

        // 사과의 위치 입력 받기
        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board[x][y] = 1; // 1은 사과가 있는 위치
        }

        int L = scanner.nextInt(); // 뱀의 방향 변환 횟수
        Queue<int[]> moves = new LinkedList<>(); // 방향 전환 정보를 저장할 큐
        for (int i = 0; i < L; i++) {
            int x = scanner.nextInt(); // 시간
            char c = scanner.next().charAt(0); // 'L'은 왼쪽, 'D'는 오른쪽
            moves.add(new int[]{x, c == 'L' ? -1 : 1}); // -1은 왼쪽, 1은 오른쪽
        }

        System.out.println(play(N, moves)); // 게임 시뮬레이션 후 결과 출력
        scanner.close();
    }

    private static int play(int N, Queue<int[]> moves) {
        int time = 0; // 현재 시간
        int direction = 0; // 처음 동쪽
        int x = 1, y = 1; // 뱀의 처음 위치
        ArrayDeque<int[]> snake = new ArrayDeque<>(); // 뱀의 몸통 위치
        snake.offerFirst(new int[]{x, y}); // 처음 뱀 위치
        board[x][y] = 2; // 뱀이 있는 위치 2

        while (true) {
            if (!moves.isEmpty() && moves.peek()[0] == time) {
                int[] move = moves.poll(); // 방향 전환
                direction = (direction + move[1] + 4) % 4; // 방향 전환 처리
            }

            int nx = x + dx[direction]; // 다음 x 위치
            int ny = y + dy[direction]; // 다음 y 위치

            // 벽이나 자신의 몸에 부딪힌 경우 게임 오버
            if (nx <= 0 || nx > N || ny <= 0 || ny > N || board[nx][ny] == 2) {
                return time + 1; // 충돌 시간
            }

            if (board[nx][ny] == 1) { // 사과가 있는 경우
                board[nx][ny] = 0; // 사과 먹기
            } else { // 사과가 없는 경우
                int[] tail = snake.pollLast(); // 꼬리를 이동
                board[tail[0]][tail[1]] = 0; // 꼬리가 있던 위치를 비움
            }

            // 뱀의 머리를 새 위치로 이동
            snake.offerFirst(new int[]{nx, ny});
            board[nx][ny] = 2; // 새로운 뱀의 머리 위치
            x = nx; // 현재 뱀의 머리 x 위치 갱신
            y = ny; // 현재 뱀의 머리 y 위치 갱신
            time++; // 시간 증가
        }
    }
}