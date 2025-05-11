import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int to, dis;
        Node(int t, int c) {
            this.to = t;
            this.dis = c;
        }
    }

    static Map<Integer, List<Node>> map = new HashMap<>();
    static int result = Integer.MAX_VALUE;
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);

        // 시작점 0과 도착점 M 추가
        set.add(0);
        set.add(M);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            // 유효한 지름길
            if (b <= M && c < b - a) {
                list.add(new int[]{a, b, c});
                set.add(a);
                set.add(b);
            }
        }

        // 기본 고속도로 간선: 인접 노드 간 거리
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        for (int i = 0; i < sorted.size() - 1; i++) {
            int u = sorted.get(i);
            int v = sorted.get(i + 1);
            map.computeIfAbsent(u, k -> new ArrayList<>())
                    .add(new Node(v, v - u));
        }

        // 지름길 간선 추가
        for (int[] i : list) {
            map.computeIfAbsent(i[0], k -> new ArrayList<>())
                    .add(new Node(i[1], i[2]));
        }

        dfs(0, 0, M);
        System.out.println(result);
    }

    static void dfs(int curr, int dist, int M) {
        if (dist >= result) return;
        if (curr == M) {
            result = Math.min(result, dist);
            return;
        }

        List<Node> nodeList = map.get(curr);
        if (nodeList == null) return;
        for (Node node : nodeList) {
            dfs(node.to, dist + node.dis, M);
        }
    }
}