class Solution {
    public int solution(int a, int b) {
        return (a * (int)Math.pow(2,9) * (int)Math.pow(5,4)) % b == 0?1:2;
    }
}