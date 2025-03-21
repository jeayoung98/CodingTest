class Solution {
    public static long solution(int w, int h) {
        return (long)w * h - (w + h - gcd(w,h));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}