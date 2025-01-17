import java.io.*;
import java.util.*;

public class Main {
    static class Snowman {
        long size;
        int first;
        int second;

        Snowman(long size, int first, int second) {
            this.size = size;
            this.first = first;
            this.second = second;
        }
    }
    
    static boolean isSharing(Snowman a, Snowman b) {
        return (a.first == b.first || a.first == b.second
                || a.second == b.first || a.second == b.second);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        
        List<Snowman> snowMans = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                snowMans.add(new Snowman(arr[i] + arr[j], i, j));
            }
        }
        
        Collections.sort(snowMans, (a, b) -> Long.compare(a.size, b.size));

        long result = Long.MAX_VALUE;
        int left = 0;
        int right = 1;
        int size = snowMans.size();

        while (right < size) {
            Snowman last  = snowMans.get(left);
            Snowman current = snowMans.get(right);

            if (!isSharing(last, current)) {
                result = Math.min(result, Math.abs(last.size - current.size));
            }
            left++;
            right++;
        }

        System.out.println(result);
    }
}
