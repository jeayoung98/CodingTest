class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {gcd(n,m),n * m / gcd(n,m)};
        return answer;
    }
    public int gcd(int a , int b){
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}