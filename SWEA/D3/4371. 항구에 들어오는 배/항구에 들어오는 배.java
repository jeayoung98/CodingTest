import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");
            int N = sc.nextInt();
            long[] arr = new long[N - 1];
            boolean[] visited = new boolean[N - 1];
            int boat = 0;
            sc.nextInt();
            for (int j = 0; j < N-1; j++) {
                arr[j] = sc.nextLong() - 1L;
            }

            for (int k = 0; k < arr.length; k++) {
                if (!visited[k]) {
                    long currentNum = arr[k];
                    visited[k] = true;

                    for (int q = k + 1; q < arr.length; q++) {
                        if (!visited[q] && arr[q] % currentNum == 0) {
                            visited[q] = true;
                        }
                    }

                    boat++;
                }
            }
            sb.append(boat).append("\n");
        }
        System.out.println(sb);
    }
}