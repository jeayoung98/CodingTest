import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arr[i]);
        }

        int maxA = Arrays.stream(A).max().orElse(-1);

        FenwickTree ft = new FenwickTree(maxA);

        long[] dp = new long[N];
        long answer = 0;

        for(int i = 0; i < N; i++) {
            long maxSum = ft.query(A[i] - 1);
            dp[i] = maxSum + A[i];
            ft.update(A[i], dp[i]);
            if(dp[i] > answer) answer = dp[i];
        }

        System.out.println(answer);
    }
    static class FenwickTree {
        int size;
        long[] tree;

        FenwickTree(int size) {
            this.size = size;
            tree = new long[size + 1];
            Arrays.fill(tree, 0);
        }

        void update(int index, long value) {
            while (index <= size) {
                if (tree[index] < value) {
                    tree[index] = value;
                }
                index += index & -index;
            }
        }

        long query(int index) {
            long result = 0;
            while (index > 0) {
                if (result < tree[index]) {
                    result = tree[index];
                }
                index -= index & -index;
            }
            return result;
        }
    }
}
