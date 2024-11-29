import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static List<Integer>[] locations;
    static Queue<Integer> queue;
    static boolean[] visited;
    static class Location {
        int x,y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            List<Location> list = new ArrayList<>();
            M = Integer.parseInt(br.readLine()); // 편의점 갯수
            String[] s = br.readLine().split(" ");
            list.add(new Location(Integer.parseInt(s[0]), Integer.parseInt(s[1]))); // 집 위치
            for (int j = 0; j < M; j++) {
                String[] s1 = br.readLine().split(" ");
                list.add(new Location(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]))); // 편의점 위치
            }
            String[] s2 = br.readLine().split(" ");
            list.add(new Location(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]))); // 목표

            isHappy(list);
        }
    }

    public static void isHappy(List<Location> list) {
        locations = new List[M + 2];
        for (int i = 0; i < locations.length; i++) {
            locations[i] = new ArrayList<>();
        }

        for(int i=0; i< locations.length; i++) {
            for(int j=i+1; j< locations.length; j++) {
                if(distance(list.get(i), list.get(j)) <= 1000){
                    locations[i].add(j);
                    locations[j].add(i);
                }
            }
        }
        System.out.println(bfs(0));
    }

    public static String bfs(int start) {
        queue = new LinkedList<>();
        visited = new boolean[M + 2];
        queue.add(start);
        visited[0] = true;
        while (!queue.isEmpty()) {
            if (visited[visited.length - 1]) return "happy";
            int current = queue.poll();
            for (int i = 0; i < locations.length; i++) {
                if (locations[i].contains(current) && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return "sad";
    }

    public static int distance(Location l1, Location l2) {
        return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y);
    }
}
