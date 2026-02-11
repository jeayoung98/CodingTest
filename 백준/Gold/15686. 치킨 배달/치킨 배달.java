import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] arr;
    static Pos[] surviveChicken;
    static List<Pos> chickenList;
    static List<Pos> houseList;
    static int M, minChickenD = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();


        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int current = Integer.parseInt(st.nextToken());
                arr[i][j] = current;
                if (current == 2){
                    chickenList.add(new Pos(i, j));
                } else if (current == 1) {
                    houseList.add(new Pos(i, j));
                }
            }
        }
            surviveChicken = new Pos[M];
            dfs(0,0);

        System.out.println(minChickenD);
    }

    // 경우의 수
    public static void dfs(int start, int depth) {
        if (depth == M) {
            calDistance();
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            surviveChicken[depth] = chickenList.get(i);
            dfs(i + 1, depth + 1);
        }
    }

    public static void calDistance() {
        int sum = 0;
        for (Pos house : houseList) {
            int minD = Integer.MAX_VALUE;
            for (Pos chicken : surviveChicken) {
                int currentD = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minD = Math.min(currentD, minD);
            }
            sum += minD;
        }
        minChickenD = Math.min(sum, minChickenD);
    }
}
