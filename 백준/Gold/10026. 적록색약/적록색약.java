import java.util.Scanner;

public class Main {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];
        int normalCount = 0;

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(grid, visited, i, j, grid[i][j]);
                    normalCount++;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'G') grid[i][j] = 'R';
            }
        }

        visited = new boolean[N][N];
        int colorBlindCount = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(grid, visited, i, j, grid[i][j]);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    public static void dfs(char[][] grid, boolean[][] visited, int x, int y, char color) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY] && grid[newX][newY] == color) {
                dfs(grid, visited, newX, newY, color);
            }
        }
    }
}
