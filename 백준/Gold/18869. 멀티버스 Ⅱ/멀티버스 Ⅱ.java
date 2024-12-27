import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] uniqueArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
            // 좌표압축
            compress(uniqueArr);
            arr[i] = uniqueArr;
        }
        int result = 0;
        for (int i = 0; i < N-1; i++) {
            int[] current = arr[i];
            for (int j = i + 1; j < N; j++) {
                // 중복된것 있으면 넘어감
                if (current.length == M && arr[j].length == M) {
                    // 같은 순위 인것들 쌍
                    boolean isSame = true;
                    for (int k = 0; k < M; k++) {
                        if (current[k] != arr[j][k]) isSame = false;
                    }
                    if (isSame) result++;
                }
            }
        }
        System.out.println(result);

    }

    public static void compress(int[] uniqueArr) {
        int[] copyArr = Arrays.copyOf(uniqueArr, uniqueArr.length);
        Arrays.sort(copyArr);
        for (int i = 0; i < uniqueArr.length; i++) {
            int index = Arrays.binarySearch(copyArr, uniqueArr[i]);
            uniqueArr[i] = index + 1;
        }
    }
}
