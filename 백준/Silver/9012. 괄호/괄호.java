import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // num 개의 문자열 입력받기
        int num = Integer.parseInt(br.readLine());

        
        for (int i = 0; i < num; i++) {
            String str = br.readLine(); // 문자열 입력받기
            if (isVps(str)) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine(); // 줄 바꿈 추가
        }
        bw.flush(); // 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
    }

    public static boolean isVps(String str) {
        while (true) {
            str = str.replace("()", ""); // "()"를 빈 문자열로 대체
            if (!str.contains("()")) {
                break; // 더 이상 "()"가 없으면 반복 종료
            }
        }
        return str.isEmpty(); // 문자열이 비어있으면 VPS, 아니면 VPS 아님
    }
}