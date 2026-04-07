import java.util.*;
import java.io.*;

public class Main {
    static int[] indegree;
    static List<Integer>[] edgeList;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        edgeList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K - 1; j++) {
                int current = Integer.parseInt(st.nextToken());
                edgeList[last].add(current);
                indegree[current]++;
                last = current;
            }
        }

        topologySort();
        System.out.println(sb);

    }

    public static void topologySort() {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int i = 0; i < edgeList[current].size(); i++) {
                int next = edgeList[current].get(i);
                indegree[next]--;

                if (indegree[next] == 0) queue.add(next);
            }

        }

        if (result.size() != N) {
            sb.append("0");
        } else {
            for (int num : result) {
                sb.append(num).append("\n");
            }
        }
    }


}