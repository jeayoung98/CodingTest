class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        int countOther = 0;
        int start = 0;
        
        // 첫 글자, 다른글자
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(start)) {
                count++;
            } else {
                countOther++;
            }
            
            // 같으면 0으로 초기화, 시작인덱스 수정
            if (count == countOther) {
                answer++;
                count = 0;
                countOther = 0;
                start = i + 1;
            }
        }
        // 마지막 남는 부분
        if (count != 0 || countOther != 0) {
            answer++;
        }

        return answer;
    }
}