import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);

        br.readLine();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        Arrays.stream(B).forEach(a -> sb.append(findLast(A, a) - findFirst(A, a)).append(" "));
        System.out.println(sb.toString());
    }
    
    public static int findFirst(int[] A, int x) {
        int left = 0;
        int right = A.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public static int findLast(int[] A, int x) {
        int left = 0;
        int right = A.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
