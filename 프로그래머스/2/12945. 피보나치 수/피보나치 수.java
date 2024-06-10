class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 1;
        int b = 1;
        for(int i = 2;i < n; i++){
            answer = (a + b) % 1234567;
            a = b % 1234567;
            b = answer;
        }
        return answer;
    }
}