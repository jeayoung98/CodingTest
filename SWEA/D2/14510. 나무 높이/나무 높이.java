import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("#").append(i + 1).append(" ");
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = Arrays.stream(arr).max().getAsInt();
            int two = 0;
            int one = 0;
            for (int tree : arr) {
                int x = max - tree;
                one += x % 2;
                two += x / 2;
            }

            int min = Integer.MAX_VALUE;
            while (true) {
                int currentMin = 0;
                if (two >= one) {
                    currentMin = Math.min(min, two * 2);
                    if(currentMin > min || one < 0) break;
                    else min = currentMin;
                } else {
                    currentMin = Math.min(min, one * 2 - 1);
                    if(currentMin > min|| one < 0 || two < 0) break;
                    else min = currentMin;
                }


                one += 2;
                two -= 1;
            }

            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}