class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            answer += count(i) % 2 == 0 ? i:-i;
        }
        return answer;
    }
    public int count(int a){
        int count = 2;
        if(a == 1) return 1;
        for(int i = 2; i <= a/2; i++){
            if(a % i == 0){
                count++;
            }
        }return count;
    }
}