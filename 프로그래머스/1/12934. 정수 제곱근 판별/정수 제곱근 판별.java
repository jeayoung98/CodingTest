class Solution {
    public long solution(long n) {
        int num = (int)Math.sqrt(n);
        if (Math.pow(num,2) == n) {
            return (long)Math.pow(num + 1, 2);
        }else return -1;
    }
}