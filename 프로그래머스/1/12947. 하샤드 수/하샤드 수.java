class Solution {
    public boolean solution(int x) {
        int sum = 0;
		int a = x;
      
		while (a >= 1) {
			sum += a % 10;
			a /= 10;
		}
        return x % sum == 0 ? true:false;
    }
}