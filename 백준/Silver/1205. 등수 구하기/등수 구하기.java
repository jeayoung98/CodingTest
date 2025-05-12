import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0]; // 현재 저장되어 있는 점수 갯수
        int M = arr[1]; // 현재 점수
        int K = arr[2]; // 총 저장될 수 있는 점수 갯수

        if (N == 0) {
            System.out.println(1);
            return;
        }
        int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (M <= score[score.length - 1] && N == K) {
            System.out.println(-1);
            return;
        }
        int max = Arrays.stream(score).max().orElse(-1);
        if (max <= M) {
            System.out.println(1);
            return;
        }
        int result = 0;
        for (int i = N - 1; i >= 0 ; i--) {
            if (score[i] > M) {
                result = i;
                break;
            }
        }

        System.out.println(result + 2);
    }
}
