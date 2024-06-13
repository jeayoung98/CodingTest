import java.util.Scanner;

public class Main {
    // 배추밭 배열과 방문 여부 배열
    static int[][] farm;
    static boolean[][] visited;

    // 가로 M, 세로 N, 배추 수 K
    static int M, N, K;

    // 상 하 좌 우
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            // 배추밭 가로, 세로, 배추수
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            // 배추밭 초기화
            farm = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 입력 및 배추밭 배열에 배추 표시
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[y][x] = 1;
            }

            // 지렁이 수
            int worms = 0;

            // 배추밭의 모든 위치를 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 있고 방문하지 않은 경우
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        // dfs를 통해 연결된 모든 배추 방문 처리
                        dfs(i, j);
                        // 지렁이 수 증가
                        worms++;
                    }
                }
            }
            System.out.println(worms);
        }
        sc.close();
    }

    
    public static void dfs(int x, int y) {
        // 현재 위치 방문
        visited[x][y] = true;

        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //  범위를 넘지 않고 다음 위치가 배추이고 방문하지 않은 경우 -> 다음 위치로 dfs
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (farm[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}