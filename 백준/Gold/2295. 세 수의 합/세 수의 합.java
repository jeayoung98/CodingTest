import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringTokenizer를 사용하여 빠른 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 번째 줄: N 입력
        int N = Integer.parseInt(st.nextToken());
        
        // 두 번째 줄부터 N개의 줄: 집합 U의 원소 입력
        int[] U = new int[N];
        for(int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }
        
        // 집합 U 정렬
        Arrays.sort(U);
        
        // 두 수의 합 리스트 생성
        int size = N * (N + 1) / 2;
        int[] sumList = new int[size];
        int index = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) { // j = i부터 시작하여 자기 자신을 포함
                sumList[index++] = U[i] + U[j];
            }
        }
        
        // 두 수의 합 리스트 정렬
        Arrays.sort(sumList);
        
        // 가능한 d를 큰 순서대로 탐색
        for(int k = N - 1; k >= 0; k--) {
            int d = U[k];
            // 가능한 z를 순회
            for(int i = 0; i < N; i++) {
                int z = U[i];
                int target = d - z;
                // 이분 탐색으로 target이 sumList에 존재하는지 확인
                if(Arrays.binarySearch(sumList, target) >= 0) {
                    // 존재하면 d를 출력하고 프로그램 종료
                    System.out.println(d);
                    return;
                }
            }
        }
        
        // 만약 조건을 만족하는 d를 찾지 못한 경우 (문제 조건상 항상 존재하므로 이 부분은 도달하지 않음)
        System.out.println(-1);
    }
}
