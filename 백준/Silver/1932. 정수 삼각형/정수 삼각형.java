import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String[] firstLine = br.readLine().split(" ");
        int[] pre = new int[1];
        pre[0] = Integer.parseInt(firstLine[0]);
        
        for (int i = 1; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int[] arr = new int[i + 1];
            
            for (int j = 0; j <= i; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }

            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[j] += pre[j];
                } else if (j == i) {
                    arr[j] += pre[j - 1];
                } else {
                    arr[j] += Math.max(pre[j - 1], pre[j]);
                }
            }
            pre = arr;
        }
        
        System.out.println(Arrays.stream(pre).max().orElse(-1));
    }
}
