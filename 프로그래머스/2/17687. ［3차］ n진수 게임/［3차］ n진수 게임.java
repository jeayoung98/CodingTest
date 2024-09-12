import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        int count = 0;
        
        // 필요한 만큼 숫자를 n진수로 변환하여 list에 추가
        while (list.size() < t * m) {
            list.addAll(basedN(count++, n));
        }
        
        // t번만큼 p번째 사람의 숫자를 추출
        for (int i = 0; i < t; i++) {
            // p번째 사람의 숫자 인덱스 계산
            int idx = i * m + (p - 1);  
            int num = list.get(idx);
            if (num >= 10) {
                // 10 이상인 경우 A, B, C, D, E, F로 변환
                answer += (char)('A' + (num - 10));
            } else {
                // 10 미만인 경우 숫자 그대로 사용
                answer += num;
            }
        }
        return answer;
    }
    
    // 숫자를 n진법으로 변환하여 리스트로 반환
    public List<Integer> basedN(int num, int n) {
        List<Integer> result = new ArrayList<>();
        do {
            result.add(0, num % n);
            num /= n;
        } while (num > 0);
        return result;
    }
}
