import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static StringTokenizer st;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = read();
            long y = read();
            points[i] = new Point(x, y);
        }

        System.out.printf("%.1f%n", cal(N));
    }

    public static double cal(int N) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            sum += points[i].x * points[next].y - points[i].y * points[next].x;
        }

        return Math.abs(sum) / 2.0;
    }

    public static long read() {
        return Long.parseLong(st.nextToken());
    }
}