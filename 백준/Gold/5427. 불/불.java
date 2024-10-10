import java.util.*;

public class Main {
    static class Fire {
        int x, y, time;
        Fire(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int w, h;
    static char[][] map;
    static Queue<Fire> fireQueue = new LinkedList<>();
    static Queue<Fire> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();  // 테스트 케이스의 수
        while (k-- > 0) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            map = new char[h][w];
            fireQueue.clear();
            queue.clear();

            for (int i = 0; i < h; i++) {
                String line = scanner.next();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        fireQueue.add(new Fire(j, i, 0));
                    } else if (map[i][j] == '@') {
                        queue.add(new Fire(j, i, 0));
                        map[i][j] = '.';
                    }
                }
            }

            String result = escapeBuilding();
            System.out.println(result);
        }
    }

    static String escapeBuilding() {
        while (!queue.isEmpty()) {
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Fire fire = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];
                    if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        fireQueue.add(new Fire(nx, ny, fire.time + 1));
                    }
                }
            }

            int q = queue.size();
            for (int i = 0; i < q; i++) {
                Fire escape = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = escape.x + dx[d];
                    int ny = escape.y + dy[d];
                    if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                        return String.valueOf(escape.time + 1);
                    }
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = '@';
                        queue.add(new Fire(nx, ny, escape.time + 1));
                    }
                }
            }
        }

        return "IMPOSSIBLE";
    }
}
