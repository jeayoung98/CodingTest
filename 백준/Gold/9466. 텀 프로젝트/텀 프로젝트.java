import java.io.*;
import java.util.*;

public class Main {
    static int[] result;
    static int M;
    static int[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int t = 0; t < N; t++) {
            M = Integer.parseInt(br.readLine());

            select = new int[M + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= M; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[M + 1];
            for(int i = 1; i <= M; i++) {
                result[select[i]]++;
            }

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= M; i++) {
            if(result[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            int selected = select[current];
            result[selected]--;
            if(result[selected] == 0) {
                queue.add(selected);
            }
        }

        int count = 0;
        for(int i = 1; i <= M; i++) {
            if(result[i] >= 1) {
                count++;
            }
        }

        return M - count;
    }
}
