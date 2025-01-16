import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> oddIndexList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 != 0) {
                oddIndexList.add(i);
            }
        }
        int size = oddIndexList.size();
        int result = 0;
        if (size == N) {
        } else if (size <= M) {
            result = N - size;
        } else {
            for (int i = 0; i < size - M; i++) {
                int currentLength = 0;
                int currentIndex = oddIndexList.get(i);
                if (i == 0) {
                    currentLength = oddIndexList.get(i + M) - M;
                    if (currentIndex == 0) currentLength--;
                } else {
                    currentLength = (oddIndexList.get(i + M) - 1) - (oddIndexList.get(i - 1) + 1) + 1 - M;
                }
                result = Math.max(currentLength, result);
            }
            result = Math.max(result, arr.length - (oddIndexList.get(size - M - 1) + 1) - M);
        }

        System.out.println(result);
    }
}
