import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;
    static Map<String, Integer> nameMap;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());

            parent = new int[2 * M];
            size = new int[2 * M];
            nameMap = new HashMap<>();
            idx = 0;

            for (int j = 0; j < 2 * M; j++) {
                parent[j] = j;
                size[j] = 1;
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!nameMap.containsKey(name1)) {
                    nameMap.put(name1, idx++);
                }
                if (!nameMap.containsKey(name2)) {
                    nameMap.put(name2, idx++);
                }

                int num1 = nameMap.get(name1);
                int num2 = nameMap.get(name2);

                sb.append(union(num1, num2)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return size[a];

        parent[b] = a;
        size[a] += size[b];

        return size[a];
    }
}