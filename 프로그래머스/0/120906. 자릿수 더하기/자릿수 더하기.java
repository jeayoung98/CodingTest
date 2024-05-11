class Solution {
    public int solution(int n) {
        int answer = 0;
        int k = n;
        for(int i = 1;i<=String.valueOf(n).length();i++){
            answer += k % 10;
            k = k / 10;
        }return answer;
    }
}