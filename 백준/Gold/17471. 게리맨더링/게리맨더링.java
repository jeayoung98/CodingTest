import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[] populationArr;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // index == 구역이름
        populationArr = new int[N + 1];
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populationArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                list[i].add(Integer.valueOf(st.nextToken()));
            }
        }

        partition(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void partition(int depth) {
        if (depth == N + 1) {
            int aSize = groupSize(true);
            int bSize = N - aSize;
            if (aSize == 0 || bSize == 0) return;

            if(!isConnected(true,aSize) || !isConnected(false, bSize)) return;

            int diff = Math.abs(populationSum(true) - populationSum(false));
            min = Math.min(diff, min);
            return;
        }

        // A group
        visited[depth] = true;
        partition(depth + 1);

        // B group
        visited[depth] = false;
        partition(depth + 1);
    }

    private static boolean isConnected(boolean flag, int size) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];

        int start = -1;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == flag) {
                start = i;
                break;
            }
        }
        if (start == -1) return false;

        queue.add(start);
        visit[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : list[current]) {
                if (!visit[next] && visited[next] == flag) {
                    visit[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == size;
    }


    private static int groupSize(boolean flag) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(visited[i] == flag) count++;
        }
        return count;
    }

    private static int populationSum(boolean flag) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == flag) sum += populationArr[i];
        }
        return sum;
    }
}
