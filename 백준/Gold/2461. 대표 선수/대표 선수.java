import java.util.*;
import java.io.*;

public class Main {
    static class Rep implements Comparable<Rep> {
        int value;
        int classNum;
        int index;

        public Rep(int value, int classIdx, int idx) {
            this.value = value;
            this.classNum = classIdx;
            this.index = idx;
        }

        @Override
        public int compareTo(Rep rep) {
            return Integer.compare(this.value, rep.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] s1 = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(s1[j]);
            }
            Arrays.sort(arr[i]);
        }

        Queue<Rep> queue = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            queue.offer(new Rep(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int result = Integer.MAX_VALUE;

        while(true) {
            Rep current = queue.poll();
            int value = current.value;
            int classNum = current.classNum;
            int index = current.index;

            result = Math.min(result, max - value);

            if(index + 1 >= M) {
                break;
            }

            int next = arr[classNum][index + 1];
            queue.offer(new Rep(next, classNum, index + 1));

            max = Math.max(max, next);
        }

        System.out.println(result);
    }
}