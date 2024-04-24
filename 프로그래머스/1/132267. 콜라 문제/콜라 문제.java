class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a){
            int service = n / a * b;
            int service1 = n % a;

            n = service + service1;
            answer += service;
        }
        return answer;
    }
}