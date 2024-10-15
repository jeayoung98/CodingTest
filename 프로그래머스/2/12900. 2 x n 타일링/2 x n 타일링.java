class Solution {
    public int solution(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1; 
        for (int i = 2; i <= n + 1; i++) {
            int c = (a + b) % 1000000007; 
            a = b; 
            b = c;
        }
        return b; 
    }
}
