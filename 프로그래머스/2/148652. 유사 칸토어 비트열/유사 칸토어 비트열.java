class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i = l; i <= r; i++){
            if(valid(i-1)) answer++;
        }
        return answer;
    }
    
    public boolean valid(long i){
        if(i < 5 && i != 2) return true;
        if(i % 5 == 2) return false;
        return valid(i / 5);
    }
}