import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] array = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(array);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Arrays.binarySearch(array, arr[i]);
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
