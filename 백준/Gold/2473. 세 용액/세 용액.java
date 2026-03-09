import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long a,b,c;
    static long min = Long.MAX_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i <= N - 2; i++) {
            twoPointer(i);
        }
        System.out.println(a + " " + b + " " + c);
    }

    public static void twoPointer(int x) {
        int left = x + 1;
        int right = N - 1;
        while (left < right) {
            long sum = arr[x] + arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                a = arr[x];
                b = arr[left];
                c = arr[right];
            }

            if (sum > 0) right --;
            else left++;
        }
    }
}