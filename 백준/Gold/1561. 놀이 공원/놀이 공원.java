import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] ride;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ride = new int[M];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ride[i] = Integer.parseInt(st.nextToken());
            max = Math.max(ride[i], max);
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }

        long left = 0;
        long right = (long) N * max;
        long time = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (count(mid) >= N) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long last = count(time - 1);

        for (int i = 0; i < M; i++) {
            if (time % ride[i] == 0) {
                last++;
                if (last == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }

    static long count(long time) {
        if (time < 0) return 0;

        long sum = M;
        for (int i = 0; i < M; i++) {
            sum += (time / ride[i]);
        }
        return sum;
    }
}