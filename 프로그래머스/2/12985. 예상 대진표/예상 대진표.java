class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        while(true){
            if(Math.min(a,b) % 2 == 1 && Math.abs(a-b) == 1) break;
            a -= a/2;
            b -= b/2;
            answer++;
        }
        return answer;
    }
}