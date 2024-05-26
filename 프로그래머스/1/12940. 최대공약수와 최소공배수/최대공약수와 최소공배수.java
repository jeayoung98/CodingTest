class Solution {
    public int[] solution(int n, int m) {
        return new int[] {gcd(n,m),n * m / gcd(n,m)};
    }
    public int gcd(int a , int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}