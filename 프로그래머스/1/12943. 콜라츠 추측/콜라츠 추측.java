class Solution {
    public int solution(long num) {
        int answer = 0;
        while (answer <= 500) {
            if (num == 1) break;
            num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
            answer++;
        }
        return (answer >= 500) ? -1 : answer;
    }
}