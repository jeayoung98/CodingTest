import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split(" ");
        int N = Integer.parseInt(first[0]); // 웅덩이 개수
        int L = Integer.parseInt(first[1]); // 널빤지 길이

        // 웅덩이의 시작 위치와 끝 위치를 저장할 리스트
        List<int[]> list = new ArrayList<>();

        // N개의 웅덩이 정보를 입력받음
        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            list.add(new int[] {start, end});
        }

        // 웅덩이를 시작 위치로 정렬
        list.sort((a, b) -> a[0] - b[0]);

        int index = 0; // 다음 널빤지 시작 위치
        int plank = 0; // 필요한 널빤지 수

        // 각 웅덩이에 대해 필요한 널빤지를 계산
        for (int i = 0; i < N; i++) {
            // 현재 덮는 위치가 웅덩이 시작 위치보다 작으면, 웅덩이 시작 위치로 이동
            if (index < list.get(i)[0]) {
                index = list.get(i)[0];
            }
            // 현재 위치가 웅덩이 끝을 덮을 때까지 널빤지를 추가
            while (index < list.get(i)[1]) {
                index += L; // 널빤지를 하나 추가하고 현재 위치를 업데이트
                plank++; // 널빤지 수 증가
            }
        }
        // 널빤지 수 출력
        System.out.println(plank);
    }
}